import java.io.*;
import java.util.*;

class DenseGraph{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
		int x = Integer.parseInt(st[2]);
		int y = Integer.parseInt(st[3]);

		HashMap<String,List<String>> map = new HashMap<>();
		List<String> child;

		Queue<String> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();

		int a, b, c, d;
		String key, value;

		for(int i = 0; i < m; i++)
		{
			st = br.readLine().split(" ");

			a = Integer.parseInt(st[0]);
			b = Integer.parseInt(st[1]);
			c = Integer.parseInt(st[2]);
			d = Integer.parseInt(st[3]);

			key = a + " " + b;
			value = c + " " + d;

			if(a <= x && x <= b)
			{
				if(!visited.contains(key))
				{
					queue.add(key);
					visited.add(key);
				}
			}

			child = map.getOrDefault(key, new ArrayList<>());
			child.add(value);
			map.put(key, child);
		}

		if(x == y)
			return 0;

		int min = 0;

		while(queue.size() > 0)
		{
			int size = queue.size();

			while(size-- > 0)
			{
				key = queue.remove();

				st = key.split(" ");
				a = Integer.parseInt(st[0]);
				b = Integer.parseInt(st[1]);

				if(a <= y && y <= b)
					return min;

				child = map.getOrDefault(key, new ArrayList<>());

				for(String s : child)
				{
					if(!visited.contains(s))
					{
						visited.add(s);
						queue.add(s);
					}
				}
			}

			min++;
		}

		return -1;
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