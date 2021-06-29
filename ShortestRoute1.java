import java.io.*;
import java.util.*;

class ShortestRoute1{

	public static class Node{
		int x;
		long length;

		public Node(int x, long length)
		{
			this.x = x;
			this.length = length;
		}
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int a, b, c;
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		HashMap<Integer,Integer> val;

		while(m-- > 0)
		{
			st = br.readLine().split(" ");
			a = Integer.parseInt(st[0]);
			b = Integer.parseInt(st[1]);
			c = Integer.parseInt(st[2]);

			val = map.getOrDefault(a, new HashMap<>());
			val.put(b, Math.min(c, val.getOrDefault(b, Integer.MAX_VALUE)));
			map.put(a, val);
		}

		long[] res = new long[n+1];
		boolean[] visited = new boolean[n+1];

		PriorityQueue<Node> queue = new PriorityQueue<>((p, q) -> p.length == q.length ? 0 : p.length < q.length ? -1 : 1);
		Node node = new Node(1, 0);
		queue.add(node);
		int count = 0;

		while(count < n)
		{
			node = queue.remove();
			if(visited[node.x])
				continue;
			visited[node.x] = true;
			res[node.x] = node.length;

			val = map.getOrDefault(node.x, new HashMap<>());

			for(Map.Entry<Integer,Integer> e : val.entrySet())
			{
				if(!visited[e.getKey()])
					queue.add(new Node(e.getKey(), node.length + e.getValue()));
			}

			count++;

		}

		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= n; i++)
			sb.append(res[i]+" ");

		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));

		solve(br);
	}
}