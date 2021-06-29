import java.io.*;
import java.util.*;

class TreeDiameter{

	static HashMap<Integer, List<Integer>> map;
	static List<Integer> child;
	static boolean[] visited;

	static int max = 0;

	public static int dfs(int node)
	{
		child = map.get(node);
		visited[node] = true;

		int max1 = -1, max2 = -1, temp;

		for(int x : child)
		{
			if(!visited[x])
			{
				temp = dfs(x);
				if(max1 == -1)
					max1 = temp;

				else
				{
					if(temp > max1)
					{
						max2 = max1;
						max1 = temp;
					}
					else
						max2 = Math.max(max2, temp);
				}
			}
		}

		visited[node] = false;

		if(max1 == -1 && max2 == -1)
			return 1;

		if(max2 == -1)
		{
			max = Math.max(max, max1);
			return 1 + max1;
		}

		max = Math.max(max, max1+max2);

		return 1 + Math.max(max1, max2);
	}

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		if(n == 1)
		{
			System.out.print(0);
			return;
		}

		map = new HashMap<>();
		child = new ArrayList<>();
		visited = new boolean[n+1];

		int x, y;
		String[] st;

		for(int i = 1; i < n; i++)
		{
			st = br.readLine().split(" ");
			x = Integer.parseInt(st[0]);
			y = Integer.parseInt(st[1]);

			child = map.getOrDefault(x, new ArrayList<>());
			child.add(y);
			map.put(x, child);

			child = map.getOrDefault(y, new ArrayList<>());
			child.add(x);
			map.put(y, child);
		}

		dfs(1);
		System.out.print(max);
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		while(t-- > 0)
			solve(br);
	}
}