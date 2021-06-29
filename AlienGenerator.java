import java.io.*;
import java.util.*;

class AlienGenerator{

	public static int solve(BufferedReader br) throws Exception
	{
		long g = Long.parseLong(br.readLine());
		long n, temp;

		int count = 0;

		for(int i = 0; i <= 10000000; i++)
		{
			n = i;
			temp = g - (n * (n + 1))/2; 
			if(temp > 0 && temp % (n + 1) == 0)
				count++;
		}

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= t; i++)
			sb.append("Case #"+i+": "+solve(br)+"\n");

		System.out.print(sb.toString());
	}
}