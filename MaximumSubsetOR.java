import java.io.*;
import java.util.*;

class MaximumSubsetOR{

	public static int[][] dp;

	public static int helper(int[] arr, int i, int or, int size, int max)
	{
		if(i == arr.length)
			return or == max ? size : arr.length;

		if(dp[or][i] != -1)
			return dp[or][i];

		return dp[or][i] = Math.min(helper(arr, i+1, or | arr[i], size+1, max), helper(arr, i+1, or, size, max));
	}
	
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];
		int max = 0;

		for(int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(st[i]);
			max |= arr[i];
		}

		dp = new int[max+1][n];

		for(int i = 0; i <= max; i++)
			Arrays.fill(dp[i], -1);

		helper(arr, 0, 0, 0, max);

		int min = n;

		for(int i = 0; i < n; i++)
		{
			if(dp[max][i] != -1)
				min = Math.min(dp[max][i], min);
		}

		System.out.print(min);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}