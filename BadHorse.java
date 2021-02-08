import java.io.*;
import java.util.*;

class BadHorse{

	public static boolean valid(int[] dp, int x, int y)
	{
		if(dp[x] != 0 && dp[y] != 0)
			return !(dp[x] == dp[y]);

		else if(dp[x] != 0)
			dp[y] = 3 ^ dp[x];
		else
			dp[x] = 3 ^ dp[y];

		return true;
	}

	public static String solve(BufferedReader br) throws Exception
	{
		int m = Integer.parseInt(br.readLine());

		HashMap<String, Integer> serial = new HashMap<>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> child;
		int n = 0;
		int x, y;

		while(m-- > 0)
		{
			String[] st = br.readLine().split(" ");

			if(serial.containsKey(st[0]))
				x = serial.get(st[0]);
			else
			{
				x = n++;
				serial.put(st[0], x);
			}

			if(serial.containsKey(st[1]))
				y = serial.get(st[1]);
			else
			{
				y = n++;
				serial.put(st[1], y);
			}

			child = map.getOrDefault(x, new ArrayList<>());
			child.add(y);
			map.put(x, child);

			child = map.getOrDefault(y, new ArrayList<>());
			child.add(x);
			map.put(y, child);
		}

		boolean[] visited = new boolean[n];
		int[] grp = new int[n];
		Queue<Integer> queue = new LinkedList<>();

		for(int i = 0; i < n; i++)
		{
			if(grp[i] == 0)
			{
				grp[i] = 1;
				queue.add(i);
				visited[i] = true;
			}

			while(!queue.isEmpty())
			{
				x = queue.remove();
				child = map.get(x);

				for(int c : child)
				{
					if(!valid(grp, x, c))
						return "No";

					if(!visited[c])
					{
						queue.add(c);
						visited[c] = true;
					}
				}
			}
		}

		return "Yes";
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}