import java.io.*;
import java.util.*;

class ShopCandle{

	public static int solve(int[] arr, int n, int x)
	{
		int i = 0, min_index, min_value;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[n-1] = 1;
		while(i < n-1)
		{
			if(i+3 >= n-1)
				break;
			min_index = i+1;
			min_value = arr[i+1];
			for(int j = 2; j <= 3; j++)
			{
				if(arr[j+i] < min_value)
				{
					min_value = arr[j+i];
					min_index = j+i;+
				}
			}
			for(int j = i+1; j < min_index; j++)
			{
				if(arr[j] <= x)
					dp[j] = 1;
			}
			dp[min_index] = 1;
			i = min_index;
		}
		while(i < n-1)
		{
			if(arr[i] <= x)
				dp[i] = 1;
			i++;
		}
		int min = 0;
		for(i = 0; i < n; i++)
		{
			if(dp[i] == 1)
				min += arr[i];
			else
				min += x;
		}
		return min;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			int res = solve(arr, n, k);
			System.out.println(res);
		}
	}
}