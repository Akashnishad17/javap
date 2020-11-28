import java.io.*;
import java.util.*;

class ShopCandle2{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int[] dp = new int[n];
		dp[0] = arr[0];
		
		if(n >= 2)
			dp[1] = dp[0] + arr[1];
		if(n >= 3)
			dp[2] = arr[2] + Math.min(dp[0]+k, dp[1]);

		for(int i = 3; i < n; i++)
			dp[i] = arr[i] + Math.min(dp[i-1], Math.min(dp[i-2] + k, dp[i-3] + 2*k));

		System.out.println(dp[n-1]);
	}

	public static void main(String[] args) throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}