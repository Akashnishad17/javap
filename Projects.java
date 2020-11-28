import java.io.*;
import java.util.*;

class Projects{

	public static int lowerBound(int[][] p, int start, int r)
	{
		int l = 0;
		int mid;
		while(r - l > 1)
		{
			mid = l + (r - l)/2;
			if(p[mid][1] < start)
				l = mid;
			else
				r = mid;
		}
		return l;
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[][] p = new int[n+1][3];

		for(int i = 1; i <= n; i++)
		{
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
			p[i][2] = sc.nextInt();
		}

		Arrays.sort(p, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b)
			{
				if(a[1] != b[1])
					return a[1] - b[1];
				return a[0] - b[0];
			}
		});

		long[] dp = new long[n+1];
		long d1, d2;

		for(int i = 1; i <= n; i++)
		{
			d1 = dp[i-1];
			d2 = p[i][2] + dp[lowerBound(p, p[i][0], i)];
			dp[i] = d1 > d2 ? d1 : d2;
		}

		System.out.print(dp[n]);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}