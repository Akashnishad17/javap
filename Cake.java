import java.io.*;
import java.util.*;

class Cake{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		
		int x = (int)Math.sqrt(n);

		for(int i = 1; i <= x; i++)
		{
		    if(i*i == n)
		        return 1;
		}

		for(int i = 1; i <= x; i++)
		{
			for(int j = 1; j <= x; j++)
			{
				if(i*i + j*j == n)
					return 2;
			}
		}

		for(int i = 1; i <= x; i++)
		{
			for(int j = 1; j <= x; j++)
			{
				for(int k = 1; k <= x; k++)
				{
					if(i*i + j*j + k*k == n)
						return 3;
				}
			}
		}

		return 4;
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