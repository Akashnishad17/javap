import java.io.*;
import java.util.*;

class TypeWriter{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String s = br.readLine();

		return recursive(s, n);
	}

	public static int recursive(String s, int n)
	{
		int[] dp = new int[26];

		int i = 0;

		int max = 0;
		char c = '-';

		while(i < n)
		{
			char ch = s.charAt(i);
			while(i + 1 < n && s.charAt(i+1) == ch)
				i++;

			dp[ch - 'a']++;
			i++;

			if(dp[ch - 'a'] > max)
			{
				max = dp[ch - 'a'];
				c = ch;
			}
		}

		int start = 0;

		while(start < n && s.charAt(start) == c)
			start++;

		if(start == n)
			return 1;

		int count = 1;

		int end = start;

		String temp = "";

		while(end < n)
		{
			if(s.charAt(end) == c)
			{
				if(temp.length() > 0)
					count += recursive(temp, temp.length());
				
				temp = "";

				start = end;

				while(start < n && s.charAt(start) == c)
					start++;

				end = start;
			}
			else
			{
				temp += s.charAt(end);
				end++;
			}
		}

		if(start < n && end >= n && temp.length() > 0)
			count += recursive(temp, temp.length());

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}