import java.io.*;
import java.util.*;

class ExpectedNumberofSSCBackUp{

	public static long mod = 998244353;
	public static long[] dp;
	public static List<List<Integer>> list;

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int m = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);
		int k = Integer.parseInt(st[2]);

		dp = new long[m*n + 1];
		list = new ArrayList<>();
		for(int i = 0; i <= n*m; i++)
			list.add(new ArrayList<>());

		if(k == 1)
			dp[1] = 1;
		else
		{
			if(m == 1)
				dfs1('x', 1, 1, n, k, k);
			else
			{
				dfs2('x', 'x', 1, 1, n, k, k);
				dfs2('x', 'y', 2, 1, n, k, (k * (k - 1)) % mod);

				//dfs(1, 1, 0, n, k, k);
				//dfs(2, 1, 0, n, k, (k * (k - 1)) % mod);


			}
		}

		long res = 0;

		for(int i = 1; i <= m*n; i++)
		{
			res = (res + (i * dp[i]) % mod) % mod;
		}

		return (res * pow(pow((long)k, (long)m*n), mod - 2)) % mod;
	}

	public static void dfs(int ssc, int index, int m, int n, int k, long count)
	{
		if(index == n)
		{
			dp[ssc] = (dp[ssc] + count) % mod;
			list.get(ssc).add((int)count);
			return;
		}

		if(m == 0)
		{
			dfs(ssc, index, 1, n, k, count);
			dfs(ssc+1, index, 1, n, k, count * (k - 1) % mod);
		}
		else
		{
			// same no
			dfs(ssc, index+1, 0, n, k, count % mod);

			dfs(ssc+1, index+1, 0, n, k, count * (k - 1) % mod);

			if(k > 2)
				dfs(ssc+1, index+1, 0, n, k, count * (k - 1) % mod);

			//diff no
			/*if(ssc > 1)
			{
				dfs(ssc, index+1, 0, n, k, count*2 % mod);

				if(k > 2)
					dfs(ssc+1, index+1, 0, n, k, count * (k - 2) % mod);
			}*/
		}
	}

	public static void dfs1(char c, int ssc, int index, int n, int k, long count)
	{
		if(index == n)
		{
			dp[ssc] = (dp[ssc] + count) % mod;
			list.get(ssc).add((int)count);
			return;
		}

		if(c == 'x')
		{
			dfs1(c, ssc, index+1, n, k, count);
			dfs1('y', ssc+1, index+1, n, k, (count * (k - 1)) % mod);
		}
		else
		{
			dfs1(c, ssc, index+1, n, k, count);
			dfs1('x', ssc+1, index+1, n, k, (count * (k - 1)) % mod);
		}
	}

	public static void dfs2(char c1, char c2, int ssc, int index, int n, int k, long count)
	{
		if(index == n)
		{
			dp[ssc] = (dp[ssc] + count) % mod;
			list.get(ssc).add((int)count);
			return;
		}
		
		if(c2 == 'x')
		{
			dfs2('x', 'x', ssc, index+1, n, k, count);
			
			dfs2('x', 'y', ssc+1, index+1, n, k, (count * (k-1) * 2) % mod);
			
			dfs2('x', 'x', ssc+1, index+1, n, k, (count * (k-1)) % mod);

			if(k > 2)
			{
				long temp = ((count * (k - 1) % mod) * (k - 2)) % mod;
				dfs2('x', 'y', ssc+2, index+1, n, k, temp);
			}
		}
		else
		{
			dfs2('x', 'x', ssc, index+1, n, k, (count * 2) % mod);
			
			dfs2('x', 'y', ssc, index+1, n, k, count);
			
			dfs2('x', 'y', ssc+2, index+1, n, k, count);

			if(k > 2)
			{
				dfs2('x', 'y', ssc+1, index+1, n, k, (count * (k - 2) * 2) % mod);
				
				dfs2('x', 'x', ssc+1, index+1, n, k, (count * (k - 2)) % mod);
				
				dfs2('x', 'y', ssc+2, index+1, n, k, (count * (k - 2) * 2) % mod);
			}

			if(k > 3)
			{
				long temp = ((count * (k - 2) % mod) * (k - 3)) % mod;
				dfs2('x', 'y', ssc+2, index+1, n, k, temp);
			}		
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