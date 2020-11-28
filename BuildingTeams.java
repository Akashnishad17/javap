import java.io.*;
import java.util.*;

class BuildingTeams{

	public static boolean validToput(int[] dp, int x, int y)
	{
		if(dp[x] != 0 && dp[y] != 0)
			return !(dp[x] == dp[y]);

		if(dp[x] == 0 && dp[y] == 0)
		{
			dp[x] = 1;
			dp[y] = 2;
		}
		else if(dp[x] != 0)
			dp[y] = 3 ^ dp[x];
		else
			dp[x] = 3 ^ dp[y];

		return true;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		HashMap<Integer,List<Integer>> map = new HashMap<>();
		List<Integer> child;
		int x = -1, y = -1;

		for(int i = 0; i < m; i++)
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

		int[] dp = new int[n+1];
		boolean[] visited = new boolean[n+1];

		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= n; i++)
		{
			if(dp[i] == 0)
			{
				if(map.containsKey(i))
					queue.add(i);
				else
					dp[i] = 1;

				visited[i] = true;
			}

			while(!queue.isEmpty())
			{
				x = queue.remove();
				child = map.get(x);

				for(int c : child)
				{
					if(!validToput(dp, x, c))
					{
						System.out.print("IMPOSSIBLE");
						return;
					}

					if(!visited[c])
					{
						visited[c] = true;
						queue.add(c);
					}
				}
			}

			sb.append(dp[i]+" ");
		}

		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));

		solve(br);
	}
}