import java.io.*;
import java.util.*;

class ConsecutiveAddingBackUp{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int r = Integer.parseInt(st[0]);
		int c = Integer.parseInt(st[1]);
		int x = Integer.parseInt(st[2]);

		long[][] a = new long[r][c];
		long[][] b = new long[r][c];

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

		long[][] prefix = new long[r+1][c+1];
		long diff;

		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				a[i][j] += prefix[i][j];

				if(j+x <= c)
				{
					diff = b[i][j] - a[i][j];
					a[i][j] = b[i][j];

					prefix[i][j+1] += diff;
					prefix[i][j+x] -= diff;
				}

				prefix[i][j+1] += prefix[i][j];
				prefix[i][j] = 0;
			}
		}

		for(int j = c - x + 1; j < c; j++)
		{
			for(int i = 0; i < r; i++)
			{
				a[i][j] += prefix[i][j];

				if(i+x <= r)
				{
					diff = b[i][j] - a[i][j];
					a[i][j] = b[i][j];

					prefix[i+1][j] += diff;
					prefix[i+x][j] -= diff;
				}

				prefix[i+1][j] += prefix[i][j];
				prefix[i][j] = 0;

				if(a[i][j] != b[i][j])
					return "No";
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