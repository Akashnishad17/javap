import java.io.*;
import java.util.*;

class ArrayDescription{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n+1];
		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		int[][] dp = new int[n+1][m+2];

		for(int i = 1; i <= n; i++)
		{
			for(int x = 1; x <= m; x++)
			{
				if(i == 1)
				{
					if(arr[i] == 0 || arr[i] == x)
						dp[i][x] = 1;
				}
				else
				{
					if(arr[i] == 0 || arr[i] == x)
						dp[i][x] = ((dp[i-1][x-1] + dp[i-1][x]) % 1000000007 + dp[i-1][x+1]) % 1000000007;
				}
			}
		}

		int res = 0;
		for(int x = 1; x <= m; x++)
			res = (res + dp[n][x]) % 1000000007;

		System.out.print(res);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}