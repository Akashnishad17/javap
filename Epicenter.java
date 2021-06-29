import java.io.*;
import java.util.*;

class Epicenter{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int h = Integer.parseInt(st[1]);
		int x = Integer.parseInt(st[2]);

		st = br.readLine().split(" ");

		int[] hotspots = new int[h];

		for(int i = 0; i < h; i++)
			hotspots[i] = Integer.parseInt(st[i]);

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> child;

		int u, v;

		for(int i = 1; i < n; i++)
		{
			st = br.readLine().split(" ");
			u = Integer.parseInt(st[0]);
			v = Integer.parseInt(st[1]);

			child = map.getOrDefault(u, new ArrayList<>());
			child.add(v);
			map.put(u, child);

			child = map.getOrDefault(v, new ArrayList<>());
			child.add(u);
			map.put(v, child);
		}

		Queue<Integer> queue;
		boolean[] visited;

		int epicenter = 0, level, cur, size;
		boolean valid;

		for(int i = 1; i <= n; i++)
		{
			queue = new LinkedList<>();
			visited = new boolean[n+1];

			queue.add(i);
			visited[i] = true;
			level = x;

			while(level > 0 && !queue.isEmpty())
			{
				size = queue.size();

				while(size-- > 0)
				{
					cur = queue.remove();

					child = map.get(cur);

					for(int c : child)
					{
						if(!visited[c])
						{
							queue.add(c);
							visited[c] = true;
						}
					}
				}

				level--;
			}

			valid = true;

			for(int hot : hotspots)
			{
				if(!visited[hot])
				{
					valid = false;
					break;
				}
			}

			if(valid)
				epicenter++;
		}

		System.out.print(epicenter);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));

		solve(br);
	}
}