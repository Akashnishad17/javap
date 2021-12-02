import java.io.*;
import java.util.*;

class PointMeeting{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long[] a = new long[n];
		long[] b = new long[n];

		for(int i = 0; i < n; i++)
			a[i] = Long.parseLong(st[i]);

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			b[i] = Long.parseLong(st[i]);

		HashMap<Long, Integer> mapC1 = new HashMap<>();
		HashMap<Long, Integer> mapC2 = new HashMap<>();
		HashMap<Long, Integer> mapX = new HashMap<>();
		HashMap<Long, Integer> mapY = new HashMap<>();
		HashSet<String> set = new HashSet<>();

		
		for(int i = 0; i < n; i++)
		{
			mapX.put(a[i], mapX.getOrDefault(a[i], 0) + 1);
			mapY.put(b[i], mapY.getOrDefault(b[i], 0) + 1);

			mapC1.put(b[i] - a[i], mapC1.getOrDefault(b[i] - a[i], 0) + 1);
			mapC2.put(b[i] + a[i], mapC2.getOrDefault(b[i] + a[i], 0) + 1);

			set.add(a[i] + " " + b[i]);
		}

		long c1, c2, x, y;
		int min = 2 * n, count;

		for(Map.Entry<Long, Integer> e1 : mapC1.entrySet())
		{
			for(Map.Entry<Long, Integer> e2 : mapC2.entrySet())
			{
				c1 = e1.getKey();
				c2 = e2.getKey();

				if((c2 - c1) % 2 != 0)
				{
					count = e1.getValue() + e2.getValue();
					count = 2 * (n - count) + count;
					min = Math.min(count, min);
				}
				else
				{
					x = (c2 - c1)/2;
					y = x + c1;

					if(set.contains(x + " " + y))
					{
						count = e1.getValue() - 1 + e2.getValue() - 1;

						if(mapX.getOrDefault(x, 0) != 0)
							count += mapX.get(x) - 1;

						if(mapY.getOrDefault(y, 0) != 0)
							count += mapY.get(y) - 1;

						count = 2 * (n - 1 - count) + count;
						min = Math.min(count, min);
					}
					else
					{
						count = e1.getValue() + e2.getValue() + mapX.getOrDefault(x, 0) + mapY.getOrDefault(y, 0);
						count = 2 * (n - count) + count;
						min = Math.min(count, min);
					}
				}
			}
		}

		for(Map.Entry<Long, Integer> e1 : mapX.entrySet())
		{
			for(Map.Entry<Long, Integer> e2 : mapY.entrySet())
			{
				x = e1.getKey();
				y = e2.getKey();

				c1 = y - x;
				c2 = y + x;

				if(set.contains(x + " " + y))
				{
					count = e1.getValue() - 1 + e2.getValue() - 1;

					if(mapC1.getOrDefault(c1, 0) != 0)
						count += mapC1.get(c1) - 1;

					if(mapC2.getOrDefault(c2, 0) != 0)
						count += mapC2.get(c2) - 1;

					count = 2 * (n - 1 - count) + count;
					min = Math.min(count, min);
				}
				else
				{
					count = e1.getValue() + e2.getValue() + mapC1.getOrDefault(c1, 0) + mapC2.getOrDefault(c2, 0);
					count = 2 * (n - count) + count;
					min = Math.min(count, min);
				}
			}
		}

		if(n < 250)
		{

		for(Map.Entry<Long, Integer> e1 : mapC1.entrySet())
		{
			for(Map.Entry<Long, Integer> e2 : mapX.entrySet())
			{
				c1 = e1.getKey();
				x = e2.getKey();

				y = x + c1;
				c2 = y + x;

				if(set.contains(x + " " + y))
				{
					count = e1.getValue() - 1 + e2.getValue() - 1;

					if(mapY.getOrDefault(y, 0) != 0)
						count += mapY.get(y) - 1;

					if(mapC2.getOrDefault(c2, 0) != 0)
						count += mapC2.get(c2) - 1;

					count = 2 * (n - 1 - count) + count;
					min = Math.min(count, min);
				}
				else
				{
					count = e1.getValue() + e2.getValue() + mapY.getOrDefault(y, 0) + mapC2.getOrDefault(c2, 0);
					count = 2 * (n - count) + count;
					min = Math.min(count, min);
				}	
			}

			for(Map.Entry<Long, Integer> e2 : mapY.entrySet())
			{
				c1 = e1.getKey();
				y =  e2.getKey();

				x = y - c1;
				c2 = y + x;

				if(set.contains(x + " " + y))
				{
					count = e1.getValue() - 1 + e2.getValue() - 1;

					if(mapX.getOrDefault(x, 0) != 0)
						count += mapX.get(x) - 1;

					if(mapC2.getOrDefault(c2, 0) != 0)
						count += mapC2.get(c2) - 1;

					count = 2 * (n - 1 - count) + count;
					min = Math.min(count, min);
				}
				else
				{
					count = e1.getValue() + e2.getValue() + mapX.getOrDefault(x, 0) + mapC2.getOrDefault(c2, 0);
					count = 2 * (n - count) + count;
					min = Math.min(count, min);
				}
			}
		}

		for(Map.Entry<Long, Integer> e1 : mapC2.entrySet())
		{
			for(Map.Entry<Long, Integer> e2 : mapX.entrySet())
			{
				c2 = e1.getKey();
				x = e2.getKey();

				y = -x + c2;
				c1 = y - x;

				if(set.contains(x + " " + y))
				{
					count = e1.getValue() - 1 + e2.getValue() - 1;

					if(mapC1.getOrDefault(c1, 0) != 0)
						count += mapC1.get(c1) - 1;

					if(mapY.getOrDefault(y, 0) != 0)
						count += mapY.get(y) - 1;

					count = 2 * (n - 1 - count) + count;
					min = Math.min(count, min);
				}
				else
				{
					count = e1.getValue() + e2.getValue() + mapC1.getOrDefault(c1, 0) + mapY.getOrDefault(y, 0);
					count = 2 * (n - count) + count;
					min = Math.min(count, min);
				}
			}

			for(Map.Entry<Long, Integer> e2 : mapY.entrySet())
			{
				c2 = e1.getKey();
				y = e2.getKey();

				x = c2 - y;
				c1 = y - x;

				if(set.contains(x + " " + y))
				{
					count = e1.getValue() - 1 + e2.getValue() - 1;

					if(mapC1.getOrDefault(c1, 0) != 0)
						count += mapC1.get(c1) - 1;

					if(mapX.getOrDefault(x, 0) != 0)
						count += mapX.get(x) - 1;

					count = 2 * (n - 1 - count) + count;
					min = Math.min(count, min);
				}
				else
				{
					count = e1.getValue() + e2.getValue() + mapC1.getOrDefault(c1, 0) + mapX.getOrDefault(x, 0);
					count = 2 * (n - count) + count;
					min = Math.min(count, min);
				}
			}
		}

		}

		return min;
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