import java.io.*;
import java.util.*;

class ExpectedNumberofSSC{

	public static long mod = 998244353;

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int m = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);
		int k = Integer.parseInt(st[2]);


		if(m == 1)
		{
			long[] dp = new long[n+1];

            dp[1] = k;
            
			for(int i = 2; i <= n; i++)
			{
				dp[i] += dp[i - 1];
				dp[i] %= mod;
				dp[i] += ((k - 1) * (dp[i-1] + pow(k, i - 1))) % mod;
				dp[i] %= mod;
			}
			
			long x = pow(k, n);
			x = pow(x, mod - 2);

			return (dp[n] * x) % mod;
		}
		else
		{
			long x = pow(k, 2 * n);
			x = pow(x, mod - 2);

			if(k == 1)
				return x;

			long[][] dp = new long[n][2];

			dp[0][0] = k;
			dp[0][1] = (2 * k * (k - 1)) % mod;

			for(int i = 1; i < n; i++)
			{
				dp[i][0] += ((k - 1) * (dp[i-1][0] + (k * pow(k, 2*(i - 1))) % mod) % mod) % mod;
				dp[i][0] %= mod;

				dp[i][0] += dp[i-1][0];
				dp[i][0] %= mod;

				dp[i][0] += (2 * dp[i-1][1]) % mod;
				dp[i][0] %= mod;

				dp[i][0] += ((k - 2) * (dp[i-1][1] + (((k * (k - 1)) % mod) * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][0] %= mod;

				dp[i][1] += ((k - 1) * (dp[i-1][0] + (k * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][1] %= mod;

				dp[i][1] += ((k - 1) * (dp[i-1][0] + (k * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][1] %= mod;

				dp[i][1] += ((((k - 2) * (k - 1)) % mod) * (dp[i-1][0] + (2 * k * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][1] %= mod;

				dp[i][1] += dp[i - 1][1];
				dp[i][1] %= mod;

				dp[i][1] += ((((k - 2)) % mod) * (dp[i - 1][1] + (((k * (k - 1)) % mod) * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][1] %= mod;

				dp[i][1] += ((((k - 2)) % mod) * (dp[i - 1][1] + (((k * (k - 1)) % mod) * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][1] %= mod;

				dp[i][1] += ((((k - 2)) % mod) * (dp[i - 1][1] + ((2 * (k * (k - 1)) % mod) * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][1] %= mod;

				dp[i][1] += ((((k - 1)) % mod) * (dp[i - 1][1] + ((2 * (k * (k - 1)) % mod) * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][1] %= mod;

				dp[i][1] += ((((k - 2) * Math.max(k - 3, 0)) % mod) * (dp[i - 1][1] + ((2 * (k * (k - 1)) % mod) * pow(k, 2 * (i - 1))) % mod) % mod) % mod;
				dp[i][1] %= mod; 
			}

			return (((dp[n-1][0] + dp[n-1][1]) % mod) * x) % mod;
		}
	}

	public static long pow(long x, long n)
	{
		if(n == 0)
			return 1;

		long half = pow(x, n/2);
		long half_prod = (half * half) % mod;

		if(n % 2 == 0)
			return half_prod;

		return (half_prod * x) % mod;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}