import java.io.*;
import java.util.*;

class AnotherTreeBackUp{

	public static HashMap<Integer, List<Integer>> map = new HashMap<>();
	public static List<HashMap<Integer, List<Integer>>> level = new ArrayList<>();
	public static int[] res;
	
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		for(int i = 0; i <= n; i++)
			level.add(new HashMap<>());

		int p;

		for(int i = 0; i < n-1; i++)
		{
			p = Integer.parseInt(st[i]);

			List<Integer> child = map.getOrDefault(p, new ArrayList<>());
			child.add(i+2);
			map.put(p, child);
		}

		int q = Integer.parseInt(br.readLine());
		res = new int[q];

		int node, task;

		for(int i = 0; i < q; i++)
		{
			st = br.readLine().split(" ");
			node = Integer.parseInt(st[0]);
			task = Integer.parseInt(st[1]);

			HashMap<Integer, List<Integer>> nodeMap = level.get(node);

			List<Integer> child = nodeMap.getOrDefault(task, new ArrayList<>());
			child.add(i);
			nodeMap.put(task, child);
		}

		dfs(1);

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < q; i++)
			sb.append(res[i]+"\n");

		System.out.print(sb.toString());
	}

	public static void dfs(int node)
	{
		if(!map.containsKey(node))
			return;

		List<Integer> child = map.get(node);
		HashMap<Integer, List<Integer>> nodeMap = level.get(node);

		for(Map.Entry<Integer, List<Integer>> e : nodeMap.entrySet())
		{
			int task = e.getKey();
			List<Integer> query = e.getValue();

			if(task % child.size() == 0)
			{
				for(int c : child)
				{
					HashMap<Integer, List<Integer>> nodeMap2 = level.get(c);

					List<Integer> query2 = nodeMap2.getOrDefault(task/child.size(), new ArrayList<>());

					if(query2.size() < query.size())
					{
						for(int q : query2)
							query.add(q);

						query2 = query;
					}
					else
					{
						for(int q : query)
							query2.add(q);
					}

					nodeMap2.put(task/child.size(), query2);
				}
			}
			else
			{
				for(int q : query)
					res[q] += task;
			}
		}

		nodeMap.clear();

		for(int c : child)
			dfs(c);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));

		solve(br);
	}
}

//https://www.hackerearth.com/challenges/competitive/dbs-campus-hack-2-hire-2021/