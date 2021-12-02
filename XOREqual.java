import java.io.*;
import java.util.*;

class XOREqual{
	public static String solve(BufferedReader br) throws Exception
	{
		String st[] = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");

		HashMap<Integer, int[]> map = new HashMap<>();

		int num;

		for(String s : st)
		{
			num = Integer.parseInt(s);

			int[] val = map.getOrDefault(num, new int[2]);

			val[0]++;

			map.put(num, val);

			num ^= x;

			if(x != 0)
			{
				val = map.getOrDefault(num, new int[2]);

				val[0]++;
				val[1]++;

				map.put(num, val);
			}
		}

		int max = 0, min = n;

		for(int[] val : map.values())
		{
			if(val[0] > max)
			{
				max = val[0];
				min = val[1];
			}
			else if(val[0] == max)
				min = Math.min(val[1], min);
		}

		return "" + max + " " + min;
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