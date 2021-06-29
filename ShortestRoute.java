import java.io.*;
import java.util.*;

class ShortestRoute{

	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int[] arr = new int[n+1];

		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st[i-1]);

		int[] prefix = new int[n+2];
		int[] suffix = new int[n+2];

		prefix[0] = -1;
		suffix[n+1] = -1;

		for(int i = 1; i <= n; i++)
		{
			if(arr[i] == 1)
				prefix[i] = i;
			else
				prefix[i] = prefix[i-1];
		}

		for(int i = n; i >= 1; i--)
		{
			if(arr[i] == 2)
				suffix[i] = i;
			else
				suffix[i] = suffix[i+1];
		}

		st = br.readLine().split(" ");
		int x, min;

		for(int i = 0; i < m; i++)
		{
			x = Integer.parseInt(st[i]);

			if(x == 1)
			{
				sb.append("0 ");
				continue;
			}
			
			min = -1;

			if(prefix[x] != -1)
				min = x - prefix[x];

			if(suffix[x] != -1)
			{
				if(min == -1)
					min = suffix[x] - x;
				else
					min = Math.min(min, suffix[x] - x);
			}

			sb.append(min+" ");
		}

		sb.append("\n");
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
			solve(br);

		System.out.print(sb.toString());
	}
}