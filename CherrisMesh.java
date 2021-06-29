import java.io.*;
import java.util.*;

class CherrisMesh{

	public static int find(int[] parent, int i)
	{
		if(parent[i] == i)
			return parent[i];

		parent[i] = find(parent, parent[i]);

		return parent[i];
	}

	public static int union(int[] parent, int[] rank, int x, int y)
	{
		int p1 = find(parent, x);
		int p2 = find(parent, y);

		if(p1 == p2)
			return 0;

		if(rank[p1] > rank[p2])
		{
			parent[p2] = p1;
			rank[p1] += rank[p2];
		}

		else
		{
			parent[p1] = p2;
			rank[p2] += rank[p1];
		}

		return 1;
	}
	
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[] parent = new int[n+1];
		int[] rank = new int[n+1];

		for(int i = 1; i <= n; i++)
		{
			parent[i] = i;
			rank[i] = 1;
		}

		int count = 0;

		while(m-- > 0)
		{
			st = br.readLine().split(" ");
			count += union(parent, rank, Integer.parseInt(st[0]), Integer.parseInt(st[1]));
		}

		HashSet<Integer> set = new HashSet<>();

		for(int i = 1; i <= n; i++)
			set.add(find(parent, i));

		count += (set.size() - 1) * 2;

		return count;
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