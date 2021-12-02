import java.io.*;
import java.util.*;

class MagicalDoors{
	public static int solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		boolean flag = false;

		int count = 0;

		for(int i = 0; i < s.length(); i++)
		{
			if(flag)
			{
				if(s.charAt(i) == '1')
				{
					count++;
					flag = false;
				}
			}
			else
			{
				if(s.charAt(i) == '0')
				{
					count++;
					flag = true;
				}
			}
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