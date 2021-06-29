import java.io.*;
import java.util.*;

class Uniform{

	public static int mod = 998244353;

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int c = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);
		int m = Integer.parseInt(st[2]);

		List<int[]> range = new ArrayList<>();

		for(int i = 0; i < c; i++)
		{
			int x = Integer.parseInt(br.readLine());

			st = br.readLine().split(" ");

			for(int j = 0; j < x; j += 2)
			{
				int l = Integer.parseInt(st[j]);
				int r = Integer.parseInt(st[j+1]);
				range.add(new int[]{l, r});
			}
		}

		Collections.sort(range, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		List<int[]> finalRange = new ArrayList<>();

		for(int[] a : range)
		{
			if(finalRange.size() == 0)
				finalRange.add(a);
			else
			{
				int[] last = finalRange.get(finalRange.size() - 1);

				if(last[1] >= a[0])
					last[1] = Math.max(last[1], a[1]);
				else
					finalRange.add(a);
			}
		}

		int[] first = finalRange.get(0);
		int[] last = finalRange.get(finalRange.size() - 1);

		long count = finalRange.size();

		if(first[0] > 1)
			count++;

		if(last[1] < n)
			count++;


		for(int i = 0; i < finalRange.size() - 1; i++)
		{
			first = finalRange.get(i);
			last = finalRange.get(i+1);

			if(last[0] - first[1] > 1)
				count++; 
		}

		return count * m % mod;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}