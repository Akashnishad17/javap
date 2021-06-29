import java.io.*;
import java.util.*;

class RectangleCut{
	public static void solve(Scanner sc)
	{
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[][] dp = new int[a+1][b+1];

		int min;
		for(int h = 1; h <= a; h++)
		{
			for(int w = 1; w <= b; w++)
			{
				if(h == w)
					continue;

				min = Integer.MAX_VALUE;

				for(int i = 1; i < h; i++)
					min = Math.min(min, 1 + dp[i][w] + dp[h-i][w]);

				for(int i = 1; i < w; i++)
					min = Math.min(min, 1 + dp[h][i] + dp[h][w-i]);

				dp[h][w] = min;
			}
		}

		System.out.print(dp[a][b]);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}