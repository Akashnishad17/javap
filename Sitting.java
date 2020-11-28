import java.io.*;
import java.util.*;

class Sitting{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int r = Integer.parseInt(st[0]);
		int c = Integer.parseInt(st[1]);

		int count = 0;

		for(int i = 1; i <= r; i++)
		{
			for(int j = 1; j <= c; j++)
			{
				if(i%3 != 0 && j%3 != 0)
					count++;

				if(i%3 == 0 && j%3 == 0)
					count++;
			}
		}

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}