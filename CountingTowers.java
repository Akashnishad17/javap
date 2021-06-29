import java.io.*;
import java.util.*;

class CountingTowers{

	public static int mod = 1000000007;

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n][2];

		dp[0][0] = 1;
		dp[0][1] = 1;

		for(int i = 1; i < n; i++)
		{
			dp[i][0] = (dp[i-1][1] + 2 * dp[i-1][0]) % mod;
			dp[i][1] = (dp[i-1][0] + 4 * dp[i-1][1]) % mod;
		}

		return (dp[n-1][0] + dp[n-1][1]) % mod;
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}