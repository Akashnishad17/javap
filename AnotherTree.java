import java.io.*;
import java.util.*;

class AnotherTree{

	public static HashMap<Integer, List<Integer>> map = new HashMap<>();
	public static long[] lcm;
	
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int p;

		for(int i = 0; i < n-1; i++)
		{
			p = Integer.parseInt(st[i]);

			List<Integer> child = map.getOrDefault(p, new ArrayList<>());
			child.add(i+2);
			map.put(p, child);
		}

		lcm = new long[n+1];

		dfsLCM(1);

		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			sb.append(dfs(Integer.parseInt(st[0]), Long.parseLong(st[1]))+"\n");
		}

		System.out.print(sb.toString());
	}

	public static long dfsLCM(int node)
	{
		if(!map.containsKey(node))
			return lcm[node] = 1;

		List<Integer> temp = map.get(node);

		long lc = 1;
		long t, gcd;

		for(int c : temp)
		{
			t = dfsLCM(c);
			gcd = gcd(t, lc);
			lc = (t * lc) / gcd;
		}

		return lcm[node] = lc * temp.size();
	}

	public static long gcd(long a, long b)
	{
		return a == 0 ? b : gcd(b%a, a);
	}

	public static long dfs(int node, long a)
	{
		if(!map.containsKey(node))
			return 0;

		if(a % lcm[node] == 0)
			return 0;

		List<Integer> temp = map.get(node);

		if(a % temp.size() != 0)
			return a;

		int count = 0;

		for(int c : temp)
			count += dfs(c, a/temp.size());

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));

		solve(br);
	}
}

//https://www.hackerearth.com/challenges/competitive/dbs-campus-hack-2-hire-2021/