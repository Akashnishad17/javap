import java.io.*;
import java.util.*;

class KingKilling{

	public static HashMap<Integer, List<Integer>> map;
	public static StringBuilder sb = new StringBuilder();

	public static class Node{
		int val, lvl;
		List<Node> nb;

		public Node(int val, int lvl)
		{
			this.val = val;
			this.lvl = lvl;
			this.nb = new ArrayList<>();
		}
	}

	public static void buildTree(Node root, int cur, int par, int lvl)
	{
		List<Integer> child = map.getOrDefault(cur, new ArrayList<>());

		for(int c : child)
		{
			if(c != par)
			{
				Node node = new Node(c, lvl + 1);
				root.nb.add(node);
				buildTree(node, c, cur, lvl + 1);
			}
		}
	}

	public static void dfs(Node root, List<int[]> leaves)
	{
		for(Node node : root.nb)
			dfs(node, leaves);

		if(root.nb.size() == 0)
			leaves.add(new int[]{root.lvl, root.val});
	}

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		map = new HashMap<>();
		List<Integer> child;

		int u, v;

		for(int i = 0; i < n - 1; i++)
		{
			String[] st = br.readLine().split(" ");

			u = Integer.parseInt(st[0]);
			v = Integer.parseInt(st[1]);

			child = map.getOrDefault(u, new ArrayList<>());
			child.add(v);
			map.put(u, child);

			child = map.getOrDefault(v, new ArrayList<>());
			child.add(u);
			map.put(v, child);
		}

		Node root = new Node(1, 0);
		buildTree(root, 1, 1, 0);

		List<int[]> res = new ArrayList<>();
		List<int[]> leaves = new ArrayList<>();

		for(Node node : root.nb)
		{
			dfs(node, leaves);
			List<int[]> temp = new ArrayList<>();
			boolean flag = false;

			Collections.sort(leaves, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
			int[] p = leaves.get(0);
			temp.add(p);

			int lvl = p[0];
			int j = 1;

			while(j < leaves.size())
			{
				while(j < leaves.size() && leaves.get(j)[0] == lvl)
				{
					if(flag)
						temp.add(new int[]{p[0] + 1, leaves.get(j)[1]});
					else
						temp.add(leaves.get(j));
					j++;
				}

				if(j < leaves.size())
				{
					temp.clear();
					flag = true;

					p[1] = leaves.get(j)[1];
					temp.add(new int[]{p[0] + 1, leaves.get(j)[1]});

					lvl = leaves.get(j)[0];
					j++;
				}
			}

			leaves.clear();

			for(int[] x : temp)
				res.add(x);
		}

		Collections.sort(res, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int day = res.get(0)[0];

		List<Integer> killers = new ArrayList<>();

		for(int[] x : res)
		{
			if(x[0] == day)
				killers.add(x[1]);
			else
				break;
		}

		sb.append(killers.size()+" "+day+"\n");

		for(int x : killers)
			sb.append(x+" ");

		sb.append("\n");
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
			solve(br);

		System.out.print(sb.toString());
	}
}