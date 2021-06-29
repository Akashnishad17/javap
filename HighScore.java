import java.io.*;
import java.util.*;

class HighScore{

	static HashMap<Integer, HashMap<Integer, Integer>> map; 
	static HashMap<Integer,Integer> val;
	static boolean[] visited;
	static boolean[] invalid;
	static long max = Long.MIN_VALUE;

	public static void dfs(int node, int n, long score)
	{
		if(invalid[node])
			return;

		if(node == n)
		{
			if(score > max)
				max = score;
			return;
		}

		val = map.getOrDefault(node, new HashMap<>());

		for(Map.Entry<Integer,Integer> e : val.entrySet())
			dfs(e.getKey(), n, score + e.getValue());
	}

	public static boolean validfy(int node, boolean flag)
	{
		if(visited[node])
		{
			invalid[node] = true;
			return;	
		}

		visited[node] = true;

		val = map.getOrDefault(node, new HashMap<>());

		for(Map.Entry<Integer,Integer> e : val.entrySet())
			validfy(e.getKey());

		visited[node] = false;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int a, b, c;
		map = new HashMap<>();
		visited = new boolean[n+1];
		invalid = new boolean[n+1];
		visited[0] = true;
		
		while(m-- > 0)
		{
			st = br.readLine().split(" ");
			a = Integer.parseInt(st[0]);
			b = Integer.parseInt(st[1]);
			c = Integer.parseInt(st[2]);

			val = map.getOrDefault(a, new HashMap<>());
			val.put(b, Math.max(c, val.getOrDefault(b, Integer.MIN_VALUE)));
			map.put(a, val);
		}

		validfy(1, false);
		dfs(1, n, 0);

		System.out.print(max != Long.MIN_VALUE ? max : -1);
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}