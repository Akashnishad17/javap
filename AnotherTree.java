import java.io.*;
import java.util.*;

class AnotherTree{

	public static HashMap<Integer, List<Integer>> map = new HashMap<>();
	public static List<Integer> child;
	
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int p;

		for(int i = 0; i < n-1; i++)
		{
			p = Integer.parseInt(st[i]);

			child = map.getOrDefault(p, new ArrayList<>());
			child.add(i+2);
			map.put(p, child);
		}

		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			sb.append(dfs(Integer.parseInt(st[0]), Integer.parseInt(st[1]))+"\n");
		}

		System.out.print(sb.toString());
	}

	public static int dfs(int node, int a)
	{
		if(!map.containsKey(node))
			return 0;

		child = map.get(node);

		if(a % child.size() != 0)
			return a;

		int count = 0;

		for(int c : child)
			count += dfs(c, a/child.size());

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));

		solve(br);
	}
}