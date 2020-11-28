import java.io.*;
import java.util.*;

class LongestIncreasing{

	public static int lowerBound(int[] dp, int l, int r, int x)
	{
		int mid;
		while(r - l > 1)
		{
			mid = l + (r - l)/2;
			if(dp[mid] >= x)
				r = mid;
			else
				l = mid;
		}
		
		return r;
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int[] dp = new int[n];
		dp[0] = arr[0];
		int len = 1;

		for(int i = 1; i < n; i++)
		{
			if(arr[i] < dp[0])
				dp[0] = arr[i];

			else if(arr[i] > dp[len-1])
				dp[len++] = arr[i];

			else
				dp[lowerBound(dp, -1, len-1, arr[i])] = arr[i];
		}

		System.out.print(len);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}