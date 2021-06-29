import java.io.*;
import java.util.*;

class CabCount{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[5];
		for(int i = 0; i < n; i++)
			dp[sc.nextInt()]++;

		int count = 0;
		count += dp[4];
		count += dp[3];
		dp[1] -= Math.min(dp[3],dp[1]);
		count += dp[2]/2;
		dp[2] %= 2;
		count += dp[1]/4;
		dp[1] %= 4;
		if(dp[2] == 0)
		{
			if(dp[1] > 1)
				count++;
		}
		else
		{
			if(d[1] <= 2)
				count++;
			else
				count += 2;
		}
		System.out.print(count);
	}
}