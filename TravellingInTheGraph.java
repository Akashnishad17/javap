import java.io.*;
import java.util.*;

class TravellingInTheGraph{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		if(m == 0)
			return n - 1;

		HashMap<Integer, List<Integer>> map = new HashMap<>();

		while(m-- > 0)
		{
			st = br.readLine().split(" ");

			int a = Integer.parseInt(st[0]);
			int b = Integer.parseInt(st[1]);

			List<Integer> list = map.getOrDefault(a, new ArrayList<>());
			list.add(b);
			map.put(a, list);

			list = map.getOrDefault(b, new ArrayList<>());
			list.add(a);
			map.put(b, list);
		}

		int count = 0;

		HashMap<Integer, List<Integer>> groups = new HashMap<>();
		HashMap<Integer, Integer> groupMap = new HashMap<>();

		for(int val : map.keySet())
		{
			if(!groupMap.containsKey(val))
			{
				count++;
				List<Integer> list = new ArrayList<>();
				dfs(val, map, groupMap, count, list);
				groups.put(count, list);
			}
		}

		for(int i = 1; i <= n; i++)
		{
			if(!groupMap.containsKey(i))
			{
				count++;
				List<Integer> list = new ArrayList<>();
				list.add(i);
				groups.put(count, list);
				groupMap.put(i, count);
			}
		}

		int start = groupMap.get(1);
		int end = groupMap.get(n);

		if(start == end)
			return 0;

		int res = 0;

		boolean[] visited = new boolean[count + 1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while(queue.size() > 0)
		{
			int size = queue.size();

			while(size-- > 0)
			{
				int cur = queue.poll();

				if(cur == end)
					return res;

				List<Integer> list = groups.get(cur);

				for(int x : list)
				{
					if(x - 1 > 0)
					{
						int g = groupMap.get(x - 1);
						if(!visited[g])
						{
							queue.add(g);
							visited[g] = true;
						}
					}
					if(x + 1 <= n)
					{
						int g = groupMap.get(x + 1);
						if(!visited[g])
						{
							queue.add(g);
							visited[g] = true;
						}
					}
				}
			}


			res++;
		}

		return res;
	}

	public static void dfs(int val, HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> groupMap, int count, List<Integer> list)
	{
		if(groupMap.containsKey(val))
			return;

		groupMap.put(val, count);
		list.add(val);

		List<Integer> child = map.getOrDefault(val, new ArrayList<>());

		for(int x : child)
			dfs(x, map, groupMap, count, list);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}