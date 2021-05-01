import java.io.*;
import java.util.*;

class PalPalString{
	
	public static String solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		int[] dp = new int[26];

		for(int i = 0; i < s.length(); i++)
			dp[s.charAt(i)-'a']++;


		int count = 0;
		int one = 0;

		for(int i = 0; i < 26; i++)
		{
			if(dp[i] > 0 && dp[i] % 2 == 0)
				count += dp[i];
			else if(dp[i] % 2 == 1)
			{
				one++;
				count += dp[i] - 1;
			}
		}

		return 2*one <= count ? "YES" : "NO";	
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