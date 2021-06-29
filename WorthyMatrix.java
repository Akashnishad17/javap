import java.io.*;
import java.util.*;

class WorthyMatrix{
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
		long k = Long.parseLong(st[2]);

		long[][] arr = new long[n+1][m+1];

		for(int i = 1; i <= n; i++)
		{
			st = br.readLine().split(" ");

			for(int j = 1; j <= m; j++)
			{
				arr[i][j] = Long.parseLong(st[j-1]);
				arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}

		long total = 0;
		int diff, r, c;

		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= m; j++)
			{
				diff = Math.min(n - i, m - j);
				r = i + diff + 1;
				c = j + diff + 1;

				total += higherBound(arr, i, j, r, c, k);
			}
		}

		return total;
	}

	public static int higherBound(long[][] arr, int rs, int cs, int rl, int cl, long k)
	{
		int rmid = -1, cmid = -1;
		int r = rs, c = cs;
		int rlast = rl; 
		long total;
		int count;

		while(rs < rl)
		{
			rmid = rs + (rl - rs)/2;
			cmid = cs + (cl - cs)/2;

			total = arr[rmid][cmid] + arr[r-1][c-1] - arr[rmid][c-1] - arr[r-1][cmid];
			count = (rmid - r + 1) * (cmid - c + 1);

			if(total/count >= k)
			{
				rl = rmid;
				cl = cmid;
			}
			else
			{
				rs = rmid + 1;
				cs = cmid + 1;
			}
		}

		return rlast - rl;
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