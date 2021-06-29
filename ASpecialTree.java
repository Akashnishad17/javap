import java.io.*;
import java.util.*;

class ASpecialTree{
	public static void solve(BufferedReader br) throws Exception
	{
		String st[] = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);
		int a = Integer.parseInt(st[2]);

		int min = n;
		int max = 1;
		int sp;

		int[] special = new int[n+1];

		st = br.readLine().split(" ");

		for(int i = 0; i < k; i++)
		{
			sp = Integer.parseInt(st[i]);
			min = Math.min(min, sp);
			max = Math.max(max, sp);
			special[sp] = 1;
		}

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> child;
		int u, v;

		for(int i = 0; i < n-1; i++)
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

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();


		if(n <= 200)
		{
			
		}
		else
		{
			for(int b = 1; b <= n; b++)
			{
				if(a == b)
				{
					sb.append(0+" ");
					sb2.append(max+" ");
				}
				else if(a > b)
				{
					sb.append((Math.abs(a-min)-Math.abs(b-min))+" ");
					sb2.append(min+" ");
				}
				else
				{
					sb.append((Math.abs(a-max)-Math.abs(b-max))+" ");
					sb2.append(max+" ");
				}
			}
		}

		System.out.println(sb.toString());
		System.out.println(sb2.toString());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
			solve(br);
	}
}