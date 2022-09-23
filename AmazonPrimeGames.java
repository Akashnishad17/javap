import java.io.*;
import java.util.*;

class AmazonPrimeGames{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long[] arr = new long[n];

		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st[i]);

		long k = Long.parseLong(br.readLine());

		long[][] dp = new long[n+1][2];

		dp[n][0] = dp[n][1] = 1;

		for(int i = n - 1; i >= 0; i--)
		{
			dp[i][0] = dp[i+1][0] + arr[i];
			dp[i][1] = Math.min(dp[i+1][1] + arr[i], dp[i+1][0] + arr[i] - Math.min(arr[i], k));
		}

		return Math.min(dp[0][0], dp[0][1]);
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}