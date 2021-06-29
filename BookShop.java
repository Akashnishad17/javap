import java.io.*;
import java.util.*;

class BookShop{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int sum = sc.nextInt();

		int[] price = new int[n+1];
		int[] pages = new int[n+1];

		for(int i = 1; i <= n; i++)
			price[i] = sc.nextInt();

		for(int i = 1; i <= n; i++)
			pages[i] = sc.nextInt();

		int[][] dp = new int[n+1][sum+1];

		for(int i = 0; i <= n; i++)
		{
			for(int s = 0; s <= sum; s++)
			{
				if(i == 0 || s == 0)
					dp[i][sum] = 0;
				else
				{
					int d1 = i == 1 ? 0 : dp[i-1][s];
					int d2 = price[i] > s ? 0 : pages[i] + dp[i-1][s - price[i]];	
					dp[i][s] = Math.max(d1, d2);
				}
			}
		}

		System.out.print(dp[n][sum]);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}