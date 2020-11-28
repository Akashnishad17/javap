import java.io.*;
import java.util.*;

class CoinCombination1{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int sum = sc.nextInt();

		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int[] dp = new int[sum+1];
		dp[0] = 1;

		for(int s = 1; s <= sum; s++)
		{
			for(int coin : arr)
			{
				if(coin <= s)
					dp[s] = (dp[s] + dp[s - coin]) % 1000000007;
			}
		}

		System.out.print(dp[sum]);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}