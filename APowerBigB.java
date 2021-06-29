import java.io.*;
import java.util.*;

class APowerBigB{

	public static int mod = 1337;
	public static long[] counts;

	public static long dfs(int[] arr, int n)
	{
		if(n == 0)
			return 1;

		int ub = arr[arr.length - n];

		long res = 1;

		for(int j = 1; j <= ub; j++)
				res = (res * counts[n]) % mod;

		res = (res * dfs(arr, n - 1)) % mod;

		return res % mod;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		int a = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		counts = new long[n+1];
		counts[0] = 1;
		counts[1] = a % mod;

		for(int i = 2; i <= n; i++)
		{
			counts[i] = 1;

			for(int j = 1; j <= 10; j++)
				counts[i] = (counts[i] * counts[i-1]) % mod;
		}

		System.out.print(dfs(arr, n));
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));

		solve(br);
	}
}