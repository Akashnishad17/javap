import java.io.*;
import java.util.*;

class Plates{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);
		int p = Integer.parseInt(st[2]);

		int[][] arr = new int[n+1][k+1];

		for(int i = 1; i <= n; i++)
		{
			st = br.readLine().split(" ");
			
			for(int j = 1; j <= k; j++)
			{
				arr[i][j] = Integer.parseInt(st[j-1]);
				if(j > 0)
					arr[i][j] += arr[i][j-1];
			}
		}

		int[][] dp = new int[n+1][p+1];

		for(int i = 1; i <= n; i++)
		{
			for(int j = 0; j <= p; j++)
			{
				for(int x = 0; x <= Math.min(j, k); x++)
					dp[i][j] = Math.max(dp[i][j], arr[i][x] + dp[i-1][j-x]);
			}
		}

		return dp[n][p];
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}