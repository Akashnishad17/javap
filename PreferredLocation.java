import java.io.*;
import java.util.*;

class PreferredLocation{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] loc = new String[]{"Malaysia", "Australia", "Germany", "Dubai", "France"};

		int[][] rating = new int[5][5];

		int x;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				x = Integer.parseInt(br.readLine());
				
				if(x < 1 || x > 5)
				{
					System.out.print("INVALID INPUT");
					return;
				}

				rating[j][x-1]++;
			}
		}


		int[] score = new int[5];
		int sum;

		for(int i = 0; i < 5; i++)
		{
			sum = 0;
			
			for(int j = 0; j < 5; j++)
				sum += rating[i][j] * (5 - j);
			
			score[i] = sum;
		}

		int max = 0;
		for(int s : score)
			max = Math.max(max, s);

		for(int i = 0; i < 5; i++)
		{
			if(max == score[i])
				System.out.println(loc[i]);
		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}