import java.io.*;
import java.util.*;

class ConsecutiveAddingX2{

	public static String solveFor2(long[][] a, long[][] b, int r, int c)
	{
		long diff;

		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c-1; j++)
			{
				if(a[i][j] != b[i][j])
				{
					diff = b[i][j] - a[i][j];
					a[i][j] += diff;
					a[i][j+1] += diff;
				}
			}
		}

		for(int i = 0; i < r-1; i++)
		{
			if(a[i][c-1] != b[i][c-1])
			{
				diff = b[i][c-1] - a[i][c-1];

				a[i][c-1] += diff;
				a[i+1][c-1] += diff;
			}
		}

		return a[r-1][c-1] == b[r-1][c-1] ? "Yes" : "No";
	}

	public static String solveFor3(long[][] a, long[][] b, int r, int c)
	{
		long diff;

		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c-2; j++)
			{
				if(a[i][j] != b[i][j])
				{
					diff = b[i][j] - a[i][j];
					a[i][j] += diff;
					a[i][j+1] += diff;
					a[i][j+2] += diff;
				}
			}
		}

		for(int i = 0; i < r-2; i++)
		{
			if(a[i][c-1] != b[i][c-1])
			{
				diff = b[i][c-1] - a[i][c-1];

				a[i][c-1] += diff;
				a[i+1][c-1] += diff;
				a[i+2][c-1] += diff;
			}

			if(a[i][c-2] != b[i][c-2])
			{
				diff = b[i][c-2] - a[i][c-2];

				a[i][c-2] += diff;
				a[i+1][c-2] += diff;
				a[i+2][c-2] += diff;
			}
		}

		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				if(a[r-i][c-j] != b[r-i][c-j])
					return "No";
			}
		}

		return "Yes";
	}

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

		if(x == 2)
			return solveFor2(a, b, r, c);

		return solveFor3(a, b, r, c);
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