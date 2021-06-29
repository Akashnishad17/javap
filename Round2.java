import java.io.*;
import java.util.*;

class Round2{

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());;

		long[] arr = new long[n+1];
		String[] st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i+1] = Long.parseLong(st[i]);

		long ans = Long.MIN_VALUE;
		long cur, best, val;
		int l, r;

		for(int i = 1; i <= n; i++)
		{
			l = i - 1;
			r = i;

			best = 0;
			cur = 0;

			while(l >= 1 && r <= n)
			{
				val = arr[l] * arr[r];
				cur += val;

				best = Math.min(best, cur);
				ans = Math.max(ans, cur - best);

				l--;
				r++;
			}

			l = i - 1;
			r = i + 1;

			best = 0;
			cur = 0;

			while(l >= 1 && r <= n)
			{
				val = arr[l] * arr[r];
				cur += val;

				best = Math.min(best, cur);
				ans = Math.max(ans, cur - best);

				l--;
				r++;
			}
		}

		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}