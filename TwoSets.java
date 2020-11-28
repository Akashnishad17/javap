import java.io.*;
import java.util.*;

class TwoSets{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int sum = (n * (n + 1))/2;
		
		if(sum % 2 != 0)
		{
			System.out.print(0);
			return;
		}

		sum /= 2;	
		int[][] dp = new int[n+1][sum+1];
		dp[0][0] = 1;

		for(int i = 1; i <= n; i++)
		{
			for(int s = 0; s <= sum; s++)
				dp[i][s] = ((s < i ? 0 : dp[i-1][s-i]) + dp[i-1][s]) % 1000000007;
		}

		System.out.print(((long)dp[n][sum] * 500000004L) % 1000000007);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}