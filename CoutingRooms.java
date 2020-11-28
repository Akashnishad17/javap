import java.io.*;
import java.util.*;

class CoutingRooms{

	public static void dfs(char[][] grid, boolean[][] visited, int n, int m, int i, int j)
	{
		if(i < 0 || j < 0 || i == n || j == m || visited[i][j] || grid[i][j] == '#')
			return;

		visited[i][j] = true;

		dfs(grid, visited, n, m, i+1, j);
		dfs(grid, visited, n, m, i-1, j);
		dfs(grid, visited, n, m, i, j+1);
		dfs(grid, visited, n, m, i, j-1);
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean[][] visited = new boolean[n][m];
		char[][] grid = new char[n][];

		for(int i = 0; i < n; i++)
			grid[i] = sc.next().toCharArray();

		int count = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if(!visited[i][j] && grid[i][j] == '.')
				{
					count++;
					dfs(grid, visited, n, m, i, j);
				}
			}
		}

		System.out.print(count);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}