import java.io.*;
import java.util.*;

class PlanetDistance{

	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st;

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> child;
		
		int[] deg = new int[n+1];
		int x, y;

		for(int i = 0; i < n; i++)
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

			deg[x]++;
			deg[y]++;
		}

		boolean[] visited = new boolean[n+1];
		boolean[] noncycle = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<>();

		for(int i = 1; i <= n; i++)
		{
			if(deg[i] == 1)
			{
				queue.add(i);
				noncycle[i] = true;
			}
		}

		while(!queue.isEmpty())
		{
			x = queue.remove();

			child = map.get(x);

			for(int c : child)
			{
				deg[c]--;

				if(deg[c] == 1 && !noncycle[c])
				{
					noncycle[c] = true;
					queue.add(c);
				}
			}
		}

		for(int i = 1; i <= n; i++)
		{
			if(!noncycle[i])
			{
				visited[i] = true;
				queue.add(i);
			}
		}

		int count = 0;
		int[] res = new int[n+1];

		while(!queue.isEmpty())
		{
			y = queue.size();

			while(y-- > 0)
			{
				x = queue.remove();
				res[x] = count;

				child = map.get(x);

				for(int c : child)
				{
					if(noncycle[c] && !visited[c])
					{
						queue.add(c);
						visited[c] = true;
					}
				}
			}

			count++;
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= n; i++)
			sb.append(res[i]+" ");

		return sb.toString();
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