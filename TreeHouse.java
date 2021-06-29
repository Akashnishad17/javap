import java.io.*;
import java.util.*;

class TreeHouse{
	
	public static HashMap<Integer, List<Integer>> map;
	public static boolean[] visited;
	public static long[] dp;
	public static int mod = 1000000007;

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		long x = Long.parseLong(st[1]);

		map = new HashMap<>();
		List<Integer> child;

		int u, v;

		for(int i = 0; i < n - 1; i++)
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

		visited = new boolean[n+1];
		dp = new long[n+1];

		visited[1] = true;
		dfs(1);

		return (dp[1] % mod * x % mod) % mod;
	}

	public static void dfs(int c)
	{
		List<Integer> child = map.getOrDefault(c, new ArrayList<>());

		for(int x : child)
		{
			if(!visited[x])
			{
				visited[x] = true;
				dfs(x);
				visited[x] = false;
			}
		}

		dp[c] = 1;
		int size = child.size();

		long[] temp = new long[size];
		int i = 0;

		for(int x : child)
		{
			if(!visited[x])
				temp[i++] = dp[x];
		}

		Arrays.sort(temp);

		for(i = 0; i < size; i++)
			dp[c] += (size - i) * temp[i];

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