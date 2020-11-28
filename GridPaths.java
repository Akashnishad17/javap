import java.io.*;
import java.util.*;

class GridPaths{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		String[] arr = new String[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.next();

		int[][] dp = new int[n][n];
		dp[0][0] = 1;

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i == 0 && j == 0)
					continue;
				if(arr[i].charAt(j) == '*')
					continue;
				else
				{
					int d1 = i == 0 ? 0 : dp[i-1][j];
					int d2 = j == 0 ? 0 : dp[i][j-1];
					dp[i][j] = (d1 + d2) % 1000000007;
				}
			}
		}
		if(arr[0].charAt(0) == '*')
			System.out.print(0);
		else
			System.out.print(dp[n-1][n-1]);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}