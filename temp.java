import java.io.*;
import java.util.*;

class temp{

	public static long mod = 998244353;
	public static long[] dp;

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int m = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);
		int k = Integer.parseInt(st[2]);

		dp = new long[m*n + 1];

		if(k == 1)
			dp[1] = 1;
		else
		{
			dp[1] = k;

			for(int i = 2; i <= n*m; i++)
				dp[i] = (dp[i-1] + ((k - 1) * (dp[i-1] + pow(k, i-1))) % mod) % mod;
		}

		long res = 0;

		for(int i = 1; i <= m*n; i++)
		{
			System.out.println(dp[i]);
			res = (res + (i * dp[i]) % mod) % mod;
		}

		return (res * pow(pow((long)k, (long)m*n), mod - 2)) % mod;
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