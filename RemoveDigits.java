import java.io.*;
import java.util.*;

class RemoveDigits{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int temp, min, d;

		for(int i = 1; i <= n; i++)
		{
			temp = i;
			min = Integer.MAX_VALUE;

			while(temp != 0)
			{
				d = temp % 10;
				temp /= 10;
				
				if(d == 0)
					continue;
				min = Math.min(min, 1 + dp[i - d]);
			}
			dp[i] = min;
		}

		System.out.print(dp[n]);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}