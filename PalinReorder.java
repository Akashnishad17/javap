import java.io.*;
import java.util.*;

class PalinReorder{
	
	public static void solve(Scanner sc)
	{
		String s = sc.next();
		int[] dp = new int[26];

		for(int i = 0; i < s.length(); i++)
			dp[s.charAt(i) - 'A']++;

		int odd = 0;
		int oddIndex = -1;
		for(int i = 0; i < 26; i++)
		{
			if(dp[i] % 2 != 0)
			{
				odd++;
				oddIndex = i;
			}
		}

		if(odd > 1)
		{
			System.out.print("NO SOLUTION");
			return;
		}

		String res1 = "";
		String res2 = "";
		int count;

		for(int i = 0; i < 26; i++)
		{
			if(dp[i] % 2 == 0)
			{
				count = dp[i]/2;
				while(count-- > 0)
				{
					res1 = res1 + (char)(i + 'A');
					res2 = (char)(i + 'A') + res2;
				}
			}
		}

		if(oddIndex != -1)
		{
			while(dp[oddIndex]-- > 0)
				res1 += (char)(oddIndex + 'A');
		}

		System.out.print(res1+""+res2);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}