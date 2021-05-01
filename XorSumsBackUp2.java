import java.io.*;
import java.util.*;

class XorSumsBackUp2{

	public static int mod = 998244353;

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int[] bits = new int[31];
		int x;

		for(int i = 0; i < n; i++)
		{
			x = Integer.parseInt(st[i]);

			for(int j = 0; j < 31; j++)
			{
				if((x & (1 << j)) > 0)
					bits[j]++; 
			}
		}

		long[] dp = new long[n+1];
		long[] fact = new long[n+1];
		fact[0] = 1;

		for(int i = 1; i <= n; i++)
			fact[i] = (fact[i-1] * i) % mod;

		int ones, zeroes;
		long temp;

		for(int i = 0; i < 31; i++)
		{
			ones = bits[i];
			zeroes = n - ones;

			for(int m = 1; m <= n; m++)
			{
				for(int r = 1; r <= ones && r <= m; r += 2)
				{
					if(m - r <= zeroes)
						dp[m] = (dp[m] + ((1 << i) * (ncr(fact, ones, r) * ncr(fact, zeroes, m - r)) % mod) % mod) % mod; 
				}
			}
		}

		for(int i = 1; i <= n; i++)
			//System.out.print(dp[i]+" ");
			dp[i] = (dp[i] + dp[i-1]) % mod;

		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(q-- > 0)
			sb.append(dp[Integer.parseInt(br.readLine())]+"\n");

		System.out.print(sb.toString());
	}

	public static long ncr(long[] fact, int n, int r)
	{
		if(r == 0)
			return 1;

		if(r == 1)
			return n;

		return (fact[n] * (pow(fact[r], mod-2) * pow(fact[n-r], mod - 2)) % mod) % mod;
	}

	public static long pow(long x, int n)
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
		
		solve(br);
	}
}