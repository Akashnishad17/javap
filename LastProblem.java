import java.io.*;
import java.util.*;

class LastProblem{

	public static long[][] arr;
	static{
		arr = new long[1001][1001];

		long count = 1;

		int i, j;

		int col = 1;

		while(col <= 1000)
		{
			i = 1;
			j = col;
			
			while(j >= 1)
			{
				arr[i][j] = count++;
				i++;
				j--;
			}

			col++;
		}

		int row = 2;

		while(row <= 1000)
		{
			i = row;
			j = 1000;

			count += i - 1;

			while(i <= 1000)
			{
				arr[i][j] = count++;
				i++;
				j--;
			}

			count += j;

			row++;


		}
	}

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int x1 = Integer.parseInt(st[0]);
		int y1 = Integer.parseInt(st[1]);
		int x2 = Integer.parseInt(st[2]);
		int y2 = Integer.parseInt(st[3]);

		long sum = 0;

		for(int i = x1; i <= x2; i++)
			sum += arr[i][y1];

		for(int j = y1+1; j <= y2; j++)
			sum += arr[x2][j];

		return sum;
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