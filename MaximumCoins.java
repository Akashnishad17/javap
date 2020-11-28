import java.io.*;
import java.util.*;

class MaximumCoins{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		int[][] grid = new int[n][n];
		int i, j;

		String[] st;
		for(i = 0; i < n; i++)
		{
			st = br.readLine().split(" ");
			for(j = 0; j < n; j++)
				grid[i][j] = Integer.parseInt(st[j]);
		}

		long max = 0;
		long sum;

		int x, y;
		for(j = 0; j < n; j++)
		{
			sum = 0;
			x = 0;
			y = j;

			while(x < n && y < n)
			{
				sum += grid[x][y];
				x++;
				y++;
			}

			if(sum > max)
				max = sum;
		}

		for(i = 1; i < n; i++)
		{
			sum = 0;
			x = i;
			y = 0;

			while(x < n && y < n)
			{
				sum += grid[x][y];
				x++;
				y++;
			}

			if(sum > max)
				max = sum;
		}

		return max;
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