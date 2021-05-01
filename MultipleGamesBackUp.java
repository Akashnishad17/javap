import java.io.*;
import java.util.*;

class MultipleGamesBackUp{
	
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);
		int m = Integer.parseInt(st[2]);

		st = br.readLine().split(" ");

		int[] arr = new int[n+1];

		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st[i-1]);

		int l, r;

		int[] range = new int[1000001];
		HashMap<String, Integer> map = new HashMap<>();

		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			l = Integer.parseInt(st[0]);
			r = Integer.parseInt(st[1]);

			if(arr[l] > m)
				continue;

			if(arr[l] <= m && m < arr[r])
			{
				range[arr[l]]++;
				range[m+1]--;
			}
			else
			{
				range[arr[l]]++;
				range[m+1]--;

				String s = arr[l] + " " + arr[r];
				map.put(s, map.getOrDefault(s, 0)+1);
			}
		}

		int v, x;

		for(Map.Entry<String, Integer> e : map.entrySet())
		{
			st = e.getKey().split(" ");
			
			l = Integer.parseInt(st[0]);
			r = Integer.parseInt(st[1]);
			v = e.getValue();

			range[r + l] -= v;
			range[r + 2 * l] += v;

			x = r + 2 * l;

			while(x+r <= m)
			{
				x += r;
				range[x] -= v;
				range[x + l] += v;

				x += l;
			}
		}

		int max = 0;

		for(int i = 1; i <= m; i++)
		{
			range[i] += range[i-1];
			max = Math.max(max,range[i]);
		}

		return max;
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