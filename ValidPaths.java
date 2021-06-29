import java.io.*;
import java.util.*;

class ValidPaths{

	public static HashMap<Integer, List<Integer>> map;
	public static long[] dp, total;
	public static int mod = 1000000007;

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		int u, v;

		map = new HashMap<>();
		List<Integer> child;

		dp = new long[n+1];
		total = new long[n+1];

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

		dfs(1, 1);

		return total[1];
	}

	public static void dfs(int cur, int par)
	{
		dp[cur] = 1;
		total[cur] = 1;

		long sum = 0, count = 0;

		List<Integer> child = map.getOrDefault(cur, new ArrayList<>());

		for(int node : child)
		{
			if(node != par)
			{
				dfs(node, cur);

				dp[cur] = (dp[cur] + 2 * dp[node]) % mod;
				total[cur] = (total[cur] + total[node] + dp[node]) % mod;

				sum += dp[node];
				count++;
			}
		}

		for(int node : child)
		{
			if(node != par)
				total[cur] = (total[cur] + (dp[node] * ((sum - dp[node] + mod) % mod)) % mod) % mod;
		}
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