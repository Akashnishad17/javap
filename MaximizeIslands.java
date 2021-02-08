import java.io.*;
import java.util.*;

class MaximizeIslands{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st  = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		String[] grid = new String[n];

		for(int i = 0; i < n; i++)
			grid[i] = br.readLine();

		int count1 = 0, count2 = 0;

		int in1 = 0, in2 = 0;

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if((i + j) % 2 == 0)
				{
					in1++;

					if(grid[i].charAt(j) == '.')
						count1++;
					else
						count2++;
				}
				else
				{
					in2++;

					if(grid[i].charAt(j) == '*')
						count1++;
					else
						count2++;
				}
			}
		}

		if(in1 == in2)
			return Math.min(count1, count2);

		return in1 > in2 ? count1 : count2;
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