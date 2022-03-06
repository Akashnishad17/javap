import java.io.*;
import java.util.*;

class PrefixZeros{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		long k = Long.parseLong(st[1]);

		String s = br.readLine();

		int l = 0, r = n - 1;

		while(r - l > 1)
		{
			int mid = l + (r - l)/2;

			if(valid(s, mid, k))
				l = mid;
			else
				r = mid - 1;
		}

		if(valid(s, r, k))
			return r + 1;
		else if(valid(s, l, k))
			return l + 1;
		return 0;
	}

	public static boolean valid(String s, int n, long k)
	{
		int prev = 0;
		long score = 0;

		for(int i = n; i >= 0; i--)
		{
			int num = s.charAt(i) - '0';
			int cur = (num + prev) % 10;
			score += cur == 0 ? 0 : (10 - cur);
			prev = (prev + (cur == 0 ? 0 : (10 - cur))) % 10;
		}

		return score <= k;
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