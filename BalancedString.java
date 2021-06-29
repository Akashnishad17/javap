import java.io.*;
import java.util.*;

class BalancedString{
	public static int solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		int n = s.length();

		int[] dp1 = new int[26];
		int[] dp2 = new int[26];

		int min = n + 1;
		boolean flag;

		for(int i = 0; i < n; i++)
		{
			Arrays.fill(dp1, 0);
			Arrays.fill(dp2, 0);

			for(int j = i; j < n; j++)
			{
				if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
					dp1[s.charAt(j) - 'a']++;
				else
					dp2[s.charAt(j) - 'A']++;

				flag = true;

				for(int k = 0; k < 26; k++)
				{
					if(dp1[k] > 0 && dp2[k] > 0)
						continue;
					else if(dp1[k] == 0 && dp2[k] == 0)
						continue;

					flag = false;
					break;
				}

				if(flag)
					min = Math.min(min, j - i + 1);
			}
		}

		return min == n + 1 ? -1 : min;
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