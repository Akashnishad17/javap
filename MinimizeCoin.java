import java.io.*;
import java.util.*;

class MinimizeCoin{
	
	public static int[] dp;
	public static int solve(int[] arr, int n, int sum)
	{
		if(sum == 0)
			return 0;

		if(dp[sum] != -2)
			return dp[sum];

		int res = -1, temp;
		int i = 0;
		while(i < n && arr[i] <= sum)
		{
			if(dp[sum-arr[i]] == -2)
				dp[sum-arr[i]] = solve(arr, n, sum - arr[i]);
			
			temp = dp[sum-arr[i]];

			if(temp != -1)
			{
				if(res == -1)
					res = temp + 1;
				else if(temp + 1 < res)
					res = temp + 1;
			}
			i++;
		}

		return dp[sum] = res;
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		
		int n = sc.nextInt();
		int sum = sc.nextInt();

		int[] arr  = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);
		dp = new int[sum+1];
		Arrays.fill(dp, -2);
		
		System.out.print(solve(arr, n, sum));
	}
}