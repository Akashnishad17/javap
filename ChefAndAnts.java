import java.io.*;
import java.util.*;

class ChefAndAnts{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][];
		long count = 0, neg, pos;
		int m;

		for(int i = 0; i < n; i++)
		{
			String[] st = br.readLine().split(" ");
			m = Integer.parseInt(st[0]);

			arr[i] = new int[m];
			neg = 0;
			pos = 0;

			for(int j = 1; j <= m; j++)
			{
				arr[i][j-1] = Integer.parseInt(st[j]);

				if(arr[i][j-1] > 0)
					pos++;
				else
					neg++;
			}

			count += pos * neg;
		}

		return count;
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