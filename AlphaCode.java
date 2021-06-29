import java.io.*;
import java.util.*;

class AlphaCode{
	public static void solve(Scanner sc)
	{
		while(true)
		{
			String s = sc.next();
			if(s.equals("0"))
				break;
			
			int n = s.length();
			int[] count = new int[n+1];
			count[0] = 1;
			count[1] = 1;

			for(int i = 2; i <= n; i++)
			{
				if(s.charAt(i-1) > '0')
					count[i] = count[i-1];

				if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7'))
					count[i] += count[i-2];
			}

			System.out.println(count[n]);
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}