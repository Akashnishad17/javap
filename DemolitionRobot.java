import java.io.*;
import java.util.*;

class DemolitionRobot{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] arr = new int[n][m];

		for(int i = 0; i < n; i++)
		{
			st =  br.readLine().split(" ");
			for(int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st[j]);
		}

		boolean[][] visited = new boolean[n][m];

		visited[0][0] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});

		int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

		int count = 0;

		while(queue.size() > 0)
		{
			int size = queue.size();

			while(size-- > 0)
			{
				int[] cur = queue.poll();

				int x = cur[0];
				int y = cur[1];

				if(arr[x][y] == 9)
					return count;

				for(int i = 0; i < 4; i++)
				{
					int newX = x + dir[i][0];
					int newY = y + dir[i][1];

					if(newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && arr[newX][newY] != 0)
					{
						queue.add(new int[]{newX, newY});
						visited[newX][newY] = true;
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
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}