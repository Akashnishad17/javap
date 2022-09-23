import java.io.*;
import java.util.*;

class KingRescue{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] arr = new int[n][m];

		for(int i = 0; i < n; i++)
		{
			st = br.readLine().split(" ");

			for(int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st[j]);
		}

		return rescue(n, m, arr);
	}

	public static int rescue(int n, int m, int[][] arr)
	{
		boolean[][] visited = new boolean[n][m];

		int count = 1;

		int[] start = new int[]{-1, -1};

		int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		for(int i = 0; i < n && start[0] == -1; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if(arr[i][j] == 1)
				{
					start[0] = i;
					start[1] = j;
					break;
				}
			}
		}

		visited[start[0]][start[1]] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);

		while(queue.size() > 0)
		{
			int size = queue.size();

			while(size-- > 0)
			{
				int[] cur = queue.poll();

				if(arr[cur[0]][cur[1]] == 2)
					return count;

				for(int[] d : dir)
				{
					int x = cur[0] + d[0];
					int y = cur[1] + d[1];

					if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] != -1 && !visited[x][y])
					{
						visited[x][y] = true;
						queue.add(new int[]{x, y});
					}
				}
			}

			count++;
		}

		return -1;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));	System.setOut(new PrintStream(new File("output.txt")));

		System.out.print(solve(br));
	}
}