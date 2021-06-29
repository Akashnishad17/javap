import java.io.*;
import java.util.*;

class Dijkstra{

	public static int minDistance(int[] arr, boolean[] visit, int n)
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int i = 0; i < n; i++)
		{
			if(!visit[i] && arr[i] <= min)
			{
				min = arr[i];
				min_index = i;
			}
		}
		return min_index;
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] adj = new int[n][n];

		int x, y, w;
		while(m-- > 0)
		{
			x = sc.nextInt();
			y = sc.nextInt();
			w = sc.nextInt();

			if(adj[x-1][y-1] == 0)
				adj[x-1][y-1] = w;
			else
				adj[x-1][y-1] = Math.min(adj[x-1][y-1], w);

			if(adj[y-1][x-1] == 0)
				adj[y-1][x-1] = w;
			else
				adj[y-1][x-1] = Math.min(adj[y-1][x-1], w);
		}

		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);

		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		int u;
		for(int i = 1; i < n; i++)
		{
			u = minDistance(dist, visited, n);
			visited[u] = true;

			for(int v = 0; v < n; v++)
			{
				if(!visited[v] && adj[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + adj[u][v] < dist[v])
					dist[v] = dist[u] + adj[u][v];
			}
		}

		boolean valid = true;
		for(int i = 1; i < n; i++)
		{
			if(dist[i] == Integer.MAX_VALUE)
			{
				valid = false;
				break;
			}
		}

		if(valid)
		{
			for(int i = 1; i < n; i++)
				System.out.print(dist[i]+" ");	
		}
		else
			System.out.print(-1);	
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input4.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}