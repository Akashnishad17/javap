import java.io.*;
import java.util.*;

class ConsecutiveAdding{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int r = Integer.parseInt(st[0]);
		int c = Integer.parseInt(st[1]);
		int x = Integer.parseInt(st[2]);

		long[][] a = new long[r+1][c+1];
		long[][] b = new long[r+1][c+1];

		for(int i = 0; i < r; i++)
		{
			st = br.readLine().split(" ");

			for(int j = 0; j < c; j++)
				a[i][j] = Integer.parseInt(st[j]);
		}

		for(int i = 0; i < r; i++)
		{
			st = br.readLine().split(" ");

			for(int j = 0; j < c; j++)
				b[i][j] = Integer.parseInt(st[j]);
		}

		long prefix, diff;

		for(int i = 0; i < r; i++)
		{
			prefix = 0;

			for(int j = 0; j < c; j++)
			{
				a[i][j] += prefix;

				diff = b[i][j] - a[i][j];

				if(j + x <= c)
				{
					a[i][j+x] -= diff;
					a[i][j] = b[i][j];
				}

				prefix += diff;

			}
		}

		for(int j = c-x+1; j < c; j++)
		{
			prefix = 0;

			for(int i = 0; i < r; i++)
			{
				a[i][j] += prefix;

				diff = b[i][j] - a[i][j];

				if(i + x <= r)
				{
					a[i+x][j] -= diff;
					a[i][j] = b[i][j];
				}

				if(a[i][j] != b[i][j])
					return "No";

				prefix += diff;
			}
		}

		return "Yes";
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