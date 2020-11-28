import java.io.*;
import java.util.*;

class Subordinates{
	static List<Integer> sub;
	static HashMap<Integer,List<Integer>> map;
	static int[] res;

	static int dfs(int parent)
	{
		if(!map.containsKey(parent))
			return 0;

		sub = map.get(parent);

		for(int x : sub)
			res[parent] += 1 + dfs(x);

		return res[parent];
	}

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		map = new HashMap<>();
		res = new int[n+1];

		int parent;
		for(int i = 0; i < st.length; i++)
		{
			parent = Integer.parseInt(st[i]);
			sub = map.getOrDefault(parent, new ArrayList<>());
			sub.add(i+2);
			map.put(parent, sub);
		}

		dfs(1);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++)
			sb.append(res[i]+" ");

		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}