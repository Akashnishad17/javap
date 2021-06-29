import java.io.*;
import java.util.*;

class CountryLeader{

	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());;

		String[] arr = new String[n];

		for(int i = 0; i < n; i++)
			arr[i] = br.readLine();

		int[] dp = new int[26];
		String res = "";

		int max = 0, count;

		for(String s : arr)
		{
			for(int i = 0; i < s.length(); i++)
			{
				if(s.charAt(i) == ' ')
					continue;

				dp[s.charAt(i) - 'A']++;
			}

			count = 0;
			for(int i = 0; i < 26; i++)
			{
				if(dp[i] > 0)
				{
					count++;
					dp[i] = 0;
				}
			}

			if(count > max)
			{
				res = s;
				max = count;
			}

			else if(count == max && res.compareTo(s) > 0)
				res = s;
		}


		return res;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}