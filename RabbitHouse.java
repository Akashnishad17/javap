import java.io.*;
import java.util.*;

class RabbitHouse{

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int r = Integer.parseInt(st[0]);
		int c = Integer.parseInt(st[1]);

		int[][] grid = new int[r][c];

		Queue<int[]> queue = new LinkedList<>();
		int max = -1;

		for(int i = 0; i < r; i++)
		{
			st = br.readLine().split(" ");

			for(int j = 0; j < c; j++)
			{
				grid[i][j] = Integer.parseInt(st[j]);

				if(grid[i][j] > max)
				{
					queue.clear();
					max = grid[i][j];
				}

				if(grid[i][j] == max)
					queue.add(new int[]{i,j,max});
			}
		}

		long res = 0;

		boolean[][] visited = new boolean[r][c];

		while(!queue.isEmpty())
		{
			int[] state = queue.remove();

			int x = state[0];
			int y = state[1];
			int lastMax = state[2];

			if(visited[x][y])
				continue;

			visited[x][y] = true;

			if(grid[x][y] < lastMax - 1)
			{
				int diff = lastMax - 1 - grid[x][y];
				res += diff;
				grid[x][y] = lastMax - 1;
			}

			lastMax = grid[x][y];

			if(x - 1 >= 0)
				queue.add(new int[]{x-1, y, lastMax});

			if(y - 1 >= 0)
				queue.add(new int[]{x, y-1, lastMax});

			if(x + 1 < r)
				queue.add(new int[]{x+1, y, lastMax});

			if(y + 1 < c)
				queue.add(new int[]{x, y+1, lastMax});
		}

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