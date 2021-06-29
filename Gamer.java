import java.io.*;
import java.util.*;

class Gamer{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		long k = Long.parseLong(st[1]);

		long[][] range = new long[n][];

		for(int i = 0; i < n; i++)
		{
			st = br.readLine().split(" ");
			range[i] = new long[]{Long.parseLong(st[0]), Long.parseLong(st[1]), Long.parseLong(st[2])};
		}

		Arrays.sort(range, (a,b) -> a[0] == b[0] ? a[1] < b[1] ? -1 : 1 : a[0] < b[0] ? -1 : 1);

		long max = Long.MIN_VALUE;

		for(int i = 0; i < n; i++)
		{
			long sum = 0;

			for(int j = i; j < n; j++)
			{
				sum += range[j][2];
				max = Math.max(max, sum - k * (range[j][1] - range[i][0]));
			}
		}

		System.out.print(max);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
	
		solve(br);
	}
}