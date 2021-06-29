import java.io.*;
import java.util.*;

class ChefInHeaven{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String s = br.readLine();

		int good = 0, year;

		for(int i = 0; i < n; i++)
		{
			if(s.charAt(i) == '1')
				good++;

			year = i + 1;

			if(year % 2 == 0)
			{
				if(good >= year/2)
					return "Yes";
			}
			else
			{
				if(good >= (year+1)/2)
					return "Yes";
			}
		}

		return "No";
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