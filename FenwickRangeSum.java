import java.io.*;
import java.util.*;

class FenwickRangeSum{

	public static int[] arr;
	public static int[] fen;
	public static int n, q;

	public static void add(int i, int val)
	{
		while(i <= n)
		{
			fen[i] += val;
			i = i + (i & (-i));
		}
	}

	public static int query(int i)
	{
		int res = 0;

		while(i > 0)
		{
			res += fen[i];
			i = i - (i & (-i));
		}

		return res;
	}

	public static int range(int l, int r)
	{
		return query(r) - query(l-1);
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]);
		q = Integer.parseInt(st[1]);

		arr = new int[n+1];
		fen = new int[n+1];

		st = br.readLine().split(" ");

		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st[i-1]);

		for(int i = 1; i <= n; i++)
			add(i, arr[i]);

		int t, x, y, res;
		StringBuilder sb = new StringBuilder();

		// 1 query, 2 update
		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			t = Integer.parseInt(st[0]);
			x = Integer.parseInt(st[1]);
			y = Integer.parseInt(st[2]);

			if(t == 1)
			{
				res = range(x, y);
				sb.append(res+"\n");
			}
			else
			{
				add(x, y - arr[x]);
				arr[x] = y;
			}
			
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