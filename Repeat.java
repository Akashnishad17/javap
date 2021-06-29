import java.io.*;
import java.util.*;

class Repeat{
	public static void solve(String s)
	{
		char c = s.charAt(0);
		int max = 1;
		int count = 1;
		
		for(int i = 1; i < s.length(); i++)
		{
			if(c == s.charAt(i))
				count++;
			else
			{
				c = s.charAt(i);
				count = 1;
			}

			max = Math.max(max, count);
		}

		System.out.print(max);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		String s = sc.next();
		solve(s);
	}
}