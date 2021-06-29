import java.io.*;
import java.util.*;

class Sarthak{
	public static int solve(String s, int n, int m)
	{
		int len = s.length();
		StringBuilder sb = new StringBuilder(s);
		int count = 1;

		char c;
		for(int i = 0; i < n; i++)
		{
			c = sb.charAt(len-1);
			sb.deleteCharAt(len-1);
			sb.insert(0, c);
		}

		boolean flag = true;
		
		while(!s.equals(sb.toString()))
		{
			for(int i = 0; i < (flag ? m : n); i++)
			{
				c = sb.charAt(len-1);
				sb.deleteCharAt(len-1);
				sb.insert(0, c);
			}
			flag = !flag;
			count++;
		}

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		String s = sc.next();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.print(solve(s, n, m));
	}
}