import java.io.*;
import java.util.*;

class ChefAndAnts2{

	public static class Index{
		List<Integer> pos;
		List<Integer> neg;

		public Index()
		{
			pos = new ArrayList<>();
			neg = new ArrayList<>();
		}
	}

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		int m;

		int[] pos = new int[n];
		int[] neg = new int[n];

		TreeMap<Integer, Index> map = new TreeMap<>();
		Index index;

		for(int i = 0; i < n; i++)
		{
			String[] st = br.readLine().split(" ");
			m = Integer.parseInt(st[0]);

			for(int j = 1; j <= m; j++)
			{
				int num = Integer.parseInt(st[j]);

				if(num < 0)
				{
					num = -num;
					index = map.getOrDefault(num, new Index());
					index.neg.add(0, i);

					map.put(num, index);

					neg[i]++;
				}
				else
				{
					index = map.getOrDefault(num, new Index());
					index.pos.add(0, i);

					map.put(num, index);
					pos[i]++;
				}
			}
		}

		long res = 0;
		int in;

		for(int num : map.keySet())
		{
			index = map.get(num);

			if(index.pos.size() + index.neg.size() == 1)
			{
				if(index.pos.size() == 1)
				{
					in = index.pos.get(0);

					res += neg[in];
					pos[in]--;
				}
				else
				{
					in = index.neg.get(0);

					res += pos[in];
					neg[in]--;
				}
			}
			else
			{
				res++;

				for(int x : index.neg)
				{
					neg[x]--;
					res += neg[x];
				}

				for(int x : index.pos)
				{
					pos[x]--;
					res += pos[x];
				}
			}
		}

		return res;
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