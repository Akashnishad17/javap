import java.io.*;
import java.util.*;
class FruitMarket{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int b = sc.nextInt();
		int[] dp = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++)
		{
			max = 0;
			for(int j = 0; j < i-b; j++)
				max = Math.max(dp[j],max);
			dp[i] = arr[i] + max;
			if(dp[i] > 0)
				dp[i] %= 1000000007;
		}
		max = 0;
		for(int x : dp)
			max = Math.max(max,x);
		System.out.print(max);
	}
}