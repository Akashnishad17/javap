import java.io.*;
import java.util.*;

class MessageRoute{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int x, y;
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		List<Integer> child;

		while(m-- > 0)
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

		boolean[] visited = new boolean[n+1];
		int[] parent = new int[n+1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		while(!queue.isEmpty())
		{
			x = queue.remove();
			if(x == n)
				break;

			child = map.getOrDefault(x, new ArrayList<>());

			for(int c : child)
			{
				if(!visited[c])
				{
					visited[c] = true;
					queue.add(c);
					parent[c] = x;
				}
			}
		}

		if(parent[n] == 0)
		{
			System.out.print("IMPOSSIBLE");
			return;
		}


		child = new ArrayList<>();

		while(parent[n] != 0)
		{
			child.add(0, n);
			n = parent[n];
		}

		child.add(0, 1);
		
		StringBuilder sb = new StringBuilder();
		for(int c : child)
			sb.append(c+" ");

		System.out.println(child.size());
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}