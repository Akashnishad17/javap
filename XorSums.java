import java.io.*;
import java.util.*;

class XorSums{

	public static long[] dp;
	public static int mod = 998244353;

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];
		dp = new long[n+1];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		dfs(arr, 0, 0, 0);

		for(int i = 1; i <= n; i++)
			dp[i] = (dp[i] + dp[i-1]) % mod;

		int q = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while(q-- > 0)
			sb.append(dp[Integer.parseInt(br.readLine())]+"\n");

		System.out.print(sb.toString());
		
	}

	public static void dfs(int[] arr, int index, int cur, int count)
	{
		if(index == arr.length)
		{
			dp[count] = (dp[count] + cur) % mod;
			return;
		}

		dfs(arr, index+1, cur^arr[index], count + 1);
		dfs(arr, index+1, cur, count);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}