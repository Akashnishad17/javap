import java.io.*;
import java.util.*;

class DreamDivisibility{

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		long k = Long.parseLong(st[1]);

		st = br.readLine().split(" ");
		long x;

		TreeSet<Long> set = new TreeSet<>();

		for(int i = 0; i < n; i++)
		{
			x = Long.parseLong(st[i]);

			if(x % k != 0)
				set.add(x % k);
		}

		while(set.size() > 0)
		{
			x = set.first();

			if(x > k/2)
				return "NO";

			set.remove(x);

			if(k % 2 == 0 && x == k/2)
				break;

			if(set.contains(k - x))
				set.remove(k - x);

			set.add(x*2);
		}

		return set.size() == 0 ? "YES" : "NO";
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