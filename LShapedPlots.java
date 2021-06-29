import java.io.*;
import java.util.*;

class LShapedPlots{

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int r = Integer.parseInt(st[0]);
		int c = Integer.parseInt(st[1]);

		int[][] grid = new int[r+1][c+1];

		for(int i = 1; i <= r; i++)
		{
			st = br.readLine().split(" ");

			for(int j = 0; j < c; j++)
				grid[i][j+1] = Integer.parseInt(st[j]);
		}

		int[][] prefixCol = new int[r+2][c+2];
		int[][] prefixRow = new int[r+2][c+2];
		int[][] suffixCol = new int[r+2][c+2];
		int[][] suffixRow = new int[r+2][c+2];

		for(int i = 1; i <= r; i++)
		{
			for(int j = 1; j <= c; j++)
			{
				if(grid[i][j] == 1)
					prefixRow[i][j] += prefixRow[i][j-1] + 1;
			}


			for(int j = c; j >= 1; j--)
			{
				if(grid[i][j] == 1)
					suffixRow[i][j] += suffixRow[i][j+1] + 1;
			}
		}

		for(int j = 1; j <= c; j++)
		{
			for(int i = 1; i <= r; i++)
			{
				if(grid[i][j] == 1)
					prefixCol[i][j] += prefixCol[i-1][j] + 1;
			}

			for(int i = r; i >= 1; i--)
			{
				if(grid[i][j] == 1)
					suffixCol[i][j] += suffixCol[i+1][j] + 1;
			}
		}

		long res = 0;

		for(int i = 1; i <= r; i++)
		{
			for(int j = 1; j <= c; j++)
			{
				if(grid[i][j] == 1)
				{
					res += helper(prefixCol[i][j], prefixRow[i][j]);
					res += helper(prefixCol[i][j], suffixRow[i][j]);
					res += helper(suffixCol[i][j], suffixRow[i][j]);
					res += helper(suffixCol[i][j], prefixRow[i][j]);
				}
			}
		}

		return res;
	}

	public static long helper(int x, int y)
	{
		if(x < 2 || y < 2)
			return 0;

		long res = 0;

		if(x > y)
		{
			int temp = x;
			x = y;
			y = temp;
		}

		int min = Math.min(x, y/2);

		if(min >= 2)
			res += min - 1;

		min = x/2;

		if(min >= 2)
			res += min - 1;

		return res;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= t; i++)
			sb.append("Case #"+i+": "+solve(br)+"\n");

		System.out.print(sb.toString());
	}
}