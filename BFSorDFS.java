import java.io.*;
import java.util.*;

class BFSorDFS{

	public static HashMap<Integer,List<Integer>> map;
	public static int[] visited;
	
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		map = new HashMap<>();

		int j, c, v;
		for(int i = 0; i < n; i++)
		{
			j = sc.nextInt();
			c = sc.nextInt();
			List<Integer> child = new ArrayList<>();
			
			while(c-- > 0)
			{
				v = sc.nextInt();
				child.add(v);

				List<Integer> childs = map.getOrDefault(v, new ArrayList<>());
				childs.add(j);
				map.put(v, childs);
			}
			
			map.put(j, child);
		}

		int x, y;
		while(true)
		{
			x = sc.nextInt();
			y = sc.nextInt();
			
			if(x == 0 && y == 0)
				break;
			
			visited = new int[n];
			if(y == 0)
				dfs(x);
			else
				bfs(x);
			
			System.out.println();
		}
	}

	public static void dfs(int v)
	{
		if(visited[v-1] == 1)
			return;
		System.out.print(v+" ");
		visited[v-1] = 1;
		for(int child : map.get(v))
			dfs(child);
	}

	public static void bfs(int v)
	{
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v-1] = 1;

		while(!queue.isEmpty())
		{
			v = queue.remove();
			System.out.print(v+" ");
			for(int child : map.get(v))
			{
				if(visited[child-1] == 0)
				{
					visited[child-1] = 1;
					queue.add(child);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input5.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		
		for(int i = 1; i <= t; i++)
		{
			System.out.println("graph "+i);
			solve(sc);
		}
	}
}