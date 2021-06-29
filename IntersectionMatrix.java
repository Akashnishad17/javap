import java.io.*;
import java.util.*;

class IntersectionMatrix{

	public static int mod = 1000000007;

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
		int b = Integer.parseInt(st[2]);

		int[][] mat = new int[n][m];

		for(int i = 0; i < n; i++)
		{
			st = br.readLine().split(" ");

			for(int j = 0; j < m; j++)
				mat[i][j] = Integer.parseInt(st[j]);
		}

		int[] row = new int[n];
		int[] col = new int[m];

		return dfs(mat, row, col, 0, 0, n, m, b);
	}

	public static int dfs(int[][] mat, int[] row, int[] col, int i, int j, int n, int m, int b)
	{
		if(i == n && j == m)
		{
			int sum = 0;

			for(int x = 0; x < n; x++)
			{
				if(row[x] == 1)
				{
					for(int y = 0; y < m; y++)
					{
						if(col[y] == 1)
							sum += mat[x][y];
					}
				}
			}

			return sum == b ? 1 : 0;
		}

		if(i < n)
		{
			int count = 0;

			row[i] = 0;
			count += dfs(mat, row, col, i+1, j, n, m, b);

			row[i] = 1;
			count += dfs(mat, row, col, i+1, j, n, m, b);

			return count % mod;
		}
		else
		{
			int count = 0;

			col[j] = 0;
			count += dfs(mat, row, col, i, j+1, n, m, b);

			col[j] = 1;
			count += dfs(mat, row, col, i, j+1, n, m, b);

			return count % mod;
		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}