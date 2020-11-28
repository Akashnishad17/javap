import java.io.*;
import java.util.*;

class CoinCombination2{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int sum = Integer.parseInt(st[1]);
		
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][sum+1];

		st = br.readLine().split(" ");
		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st[i-1]);

		for(int i = 1; i <= n; i++)
		{
			for(int s = 0; s <= sum; s++)
			{
				if(s == 0)
					dp[i][s] = 1;
				else
				{
					int d1 = i == 1 ? 0 : dp[i-1][s];
					int d2 = arr[i] > s ? 0 : dp[i][s - arr[i]];
					dp[i][s] = (d1 + d2) % 1000000007;
				}
			}
		}	
		System.out.print(dp[n][sum]);
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}