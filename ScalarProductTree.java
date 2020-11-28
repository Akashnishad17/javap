import java.io.*;
import java.util.*;

class ScalarProductTree{

	public static long mod = 4294967296L;

	public static class Node{
		int parent;
		long val;
		long pre;

		public Node(long val)
		{
			this.val = val;
			pre = (val * val) % 4294967296L;
		}
	}

	public static HashMap<String, Long> lazy; 

	public static long query(int a, int b, Node[] nodes)
	{
		long res = 0;

		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();

		int min = a, max = b;

		while(a != b)
		{
			min = Math.min(a, b);
			max = Math.max(a, b);

			if(lazy.containsKey(String.valueOf(min)+"-"+String.valueOf(max)))
				break;

			res =  (res + (nodes[a].val * nodes[b].val) % mod) % mod;
			
			a = nodes[a].parent;
			b = nodes[b].parent;

			first.add(0, min);
			second.add(0, max);
		}

		long val = a == b ? nodes[a].pre : lazy.get(String.valueOf(min)+"-"+String.valueOf(max));
		res = (res + val) % mod;

		int i = 0;

		while(i < first.size())
		{
			min = first.get(i);
			max = second.get(i);

			val = (val + (nodes[min].val * nodes[max].val) % mod) % mod;
			lazy.put(String.valueOf(min)+"-"+String.valueOf(max), val);
			i++;
		}

		return res;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);
		
		st = br.readLine().split(" ");
		Node[] nodes = new Node[n+1];

		for(int i = 1; i <= n; i++)
			nodes[i] = new Node(Long.parseLong(st[i-1]));

		HashMap<Integer,List<Integer>> map = new HashMap<>();
		lazy = new HashMap<>();
		List<Integer> child;

		int x, y;

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

		boolean[] visited = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		visited[1] = true;

		while(!queue.isEmpty())
		{
			x = queue.remove();
			child = map.get(x);

			for(int c : child)
			{
				if(!visited[c])
				{
					visited[c] = true;
					queue.add(c);

					nodes[c].parent = x;
					nodes[c].pre = (nodes[x].pre + nodes[c].pre) % mod;
				}
			}
		}

		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			x = Integer.parseInt(st[0]);
			y = Integer.parseInt(st[1]);

			System.out.println(query(x, y, nodes));
		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}