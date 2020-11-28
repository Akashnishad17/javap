import java.io.*;
import java.util.*;

class DMST{

	public static class Edge{
		
		int v1;
		int v2;
		int length;
		
		public Edge(int v1, int v2, int length)
		{
			this.v1 = v1;
			this.v2 = v2;
			this.length = length;
		}
	}

	public static class Subset{

		int rank, parent;
		public Subset(int v)
		{
			this.parent = v;
			this.rank = 1;
		}
	}

	public static int getDistance(int[] a, int[] b, int d)
	{
		int res = 0;

		for(int i = 0; i < d; i++)
			res += (int)Math.abs(a[i] - b[i]);

		return res;
	}

	public static int find(Subset[] subs, int i)
	{
		if(subs[i].parent != i)
			subs[i].parent = find(subs, subs[i].parent);

		return subs[i].parent;
	}

	public static void union(Subset[] subs, int x, int y)
	{
		int p1 = find(subs, x);
		int p2 = find(subs, y);

		if(subs[p1].rank > subs[p2].rank)
		{
			subs[p2].parent = p1;
			subs[p1].rank += subs[p2].rank;
		}
		else
		{
			subs[p1].parent = p2;
			subs[p2].rank += subs[p1].rank;
		}
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int d = sc.nextInt();

		int[][] arr = new int[n][d];

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < d; j++)
				arr[i][j] = sc.nextInt();
		}

		int total = (n*(n-1))/2;
		Edge[] edges = new Edge[total];
		int count = 0;
		
		for(int i = 0; i < n-1; i++)
		{
			for(int j = i + 1; j < n; j++)
				edges[count++] = new Edge(i, j, getDistance(arr[i], arr[j], d));
		}

		Arrays.sort(edges, new Comparator<Edge>(){
			
			@Override
			public int compare(Edge a, Edge b)
			{
				return b.length - a.length;
			}
		});

		Subset[] subs = new Subset[n];
		for(int i = 0; i < n; i++)
			subs[i] = new Subset(i);

		int i = 0;
		int e = 0;
		int cost = 0;
		int x, y;

		while(e < n - 1)
		{
			x = find(subs, edges[i].v1);
			y = find(subs, edges[i].v2);
			
			if(x != y)
			{
				e++;
				cost += edges[i].length;
				union(subs, x, y);
			}
			
			i++;
		}

		System.out.print(cost);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}

/*
5 3
1 4 5 -> 10
2 7 9 -> 16
3 2 1 -> 6
4 3 2 -> 9
6 8 4 -> 18
*/
