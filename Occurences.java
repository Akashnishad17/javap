import java.io.*;
import java.util.*;

class Occurences{
	public static String solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		int[] dp = new int[26];

		for(int i = 0; i < s.length(); i++)
			dp[s.charAt(i) - 'a']++;

		String res = "";

		for(int i = 0; i < s.length(); i++)
		{
			int index = s.charAt(i) - 'a';
			if(dp[index] > 0)
			{
				res = res + s.charAt(i) + dp[index];
				dp[index] = 0;
			}
		}

		return res;
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