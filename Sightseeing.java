import java.io.*;
import java.util.*;

class Sightseeing{

	public static long[] s, f, d;

	public static long getArrival(int index, long time)
	{
		if(time <= s[index])
			return s[index] + d[index];

		if((time - s[index]) % f[index] == 0)
			return time + d[index];

		return time + d[index] - ((time - s[index]) % f[index]) + f[index];
	}

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		long ts = Long.parseLong(st[1]);
		long tf = Long.parseLong(st[2]);

		s = new long[n-1];
		f = new long[n-1];
		d = new long[n-1];

		for(int i = 0; i < n-1; i++)
		{
			st = br.readLine().split(" ");
			s[i] = Long.parseLong(st[0]);
			f[i] = Long.parseLong(st[1]);
			d[i] = Long.parseLong(st[2]);
		}

		long[][] dp = new long[n][n];
		
		for(int i = 1; i < n; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				if(j == 0)
					dp[i][j] = getArrival(i-1, dp[i-1][j]);

				else if(i == j)
					dp[i][j] = getArrival(i-1, dp[i-1][j-1] + ts);

				else
					dp[i][j] = Math.min(getArrival(i-1, dp[i-1][j]), getArrival(i-1, dp[i-1][j-1] + ts));
			}
		}

		int max = -1;

		for(int i = 0; i < n; i++)
		{
			if(dp[n-1][i] <= tf)
				max = i;
		}

		return max == -1 ? "IMPOSSIBLE" : String.valueOf(max);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}