import java.io.*;
import java.util.*;

class BuildingRoads{

	public static int find(int[] parent, int x)
	{
		if(parent[x] == x)
			return parent[x];

		parent[x] = find(parent, parent[x]);

		return parent[x];
	}

	public static void union(int[] parent, int[] rank, int x, int y)
	{
		int p1 = find(parent, x);
		int p2 = find(parent, y);

		if(p1 == p2)
			return;

		if(rank[p1] > rank[p2])
		{
			parent[p2] = parent[p1];
			rank[p1] += rank[p2];
		}
		else
		{
			parent[p1] = parent[p2];
			rank[p2] += rank[p1];
		}
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] parent = new int[n+1];
		int[] rank = new int[n+1];
		Arrays.fill(rank, 1);

		for(int i = 1; i <= n; i++)
			parent[i] = i;

		int x, y;
		while(m-- > 0)
		{
			x = sc.nextInt();
			y = sc.nextInt();

			union(parent, rank, x, y);
		}

		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		for(int i = 1; i <= n; i++)
		{
			parent[i] = find(parent, i);

			if(!set.contains(parent[i]))
			{
				list.add(parent[i]);
				set.add(parent[i]);
			}
		}

		System.out.println(list.size()-1);
		
		for(int i = 1; i < list.size(); i++)
			System.out.println(list.get(i-1)+" "+list.get(i));

	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}