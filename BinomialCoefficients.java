import java.io.*;
import java.util.*;

class BinomialCoefficients{

	public static long[] dp;
	public static int mod = 1000000007;

	static{
		dp = new long[1000001];
		dp[0] = 1;

		for(int i = 1; i<= 1000000; i++)
			dp[i] = (dp[i-1] * i) % mod;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int a = Integer.parseInt(st[0]);
		int b = Integer.parseInt(st[1]);

		return dp[a] * gcd(dp[b]) * gcd(dp[a-b]) % mod;
	}

	public static long gcd(long a)
	{
		long m = mod;
		long q, t, x = 1, y = 0;

		while(a > 1)
		{
			q = a / m;
			t = m;

			m = a % m;
			a = t;
			t = y;

			y = x - q * y;
			x = t;
		}

		if(x < 0)
			x += mod;

		return x;
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