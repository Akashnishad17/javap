import java.io.*;
import java.util.*;

class DiceCombination{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		long[] dp = new long[n+1];
		dp[0] = 1;

		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= 6; j++)
			{
				if(i-j < 0)
					break;
				dp[i] += dp[i-j];
				dp[i] %= 1000000007;
			}
		}
		System.out.print(dp[n]);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		int t = 1;
		while(t-- > 0)
		{
			solve(sc);
		}
	}
}