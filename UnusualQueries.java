import java.io.*;
import java.util.*;

class UnusualQueries{

	public static int lowerBound(int[] dp, int l, int r, int x)
	{
		int mid;
		while(r - l > 1)
		{
			mid = l + (r - l)/2;
			if(dp[mid] >= x)
				r = mid;
			else
				l = mid;
		}
		
		return r;
	}

	public static int query(int[] arr, int l, int r)
	{
		if(l == r)
			return 1;

		int[] dp = new int[r-l+1];
		int len = 1;
		dp[0] = arr[l];

		for(int i = l+1; i <= r; i++)
		{
			if(arr[i] < dp[0])
				dp[0] = arr[i];

			else if(arr[i] > dp[len-1])
				dp[len++] = arr[i];

			else
				dp[lowerBound(dp, -1, len-1, arr[i])] = arr[i];
		}

		return len;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);
		int s = Integer.parseInt(st[2]);

		st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);
		
		int last = 0, x, y, temp;
		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			x = Integer.parseInt(st[0]);
			y = Integer.parseInt(st[1]);

			x = (x + s*last - 1) % n;
			y = (y + s*last - 1) % n;

			if(x > y)
			{
				temp = x;
				x = y;
				y = temp;
			}

			last = query(arr, x, y);
			System.out.println(last);
		}

	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}