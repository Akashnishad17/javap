import java.io.*;
import java.util.*;

class CommonAnagrams{

	public static void fillCounts(int[][] dp, String s, int l)
	{
		for(int i = 1; i <= l; i++)
		{
			for(int j = 0; j < 26; j++)
				dp[i][j] = dp[i-1][j];

			dp[i][s.charAt(i-1) - 'A']++;
		}
	}

	public static int checkAnagram(int[][] dp, int[] temp, int d, int l)
	{
		int[] t = new int[26];

		for(int i = 1; i <= l - d; i++)
		{
			for(int k = 0; k < 26; k++)
				t[k] =  dp[i+d][k] - dp[i-1][k];

			if(isValid(temp, t))
				return 1;
		}

		return 0;
	}

	public static boolean isValid(int[] t1, int[] t2)
	{
		for(int i = 0; i < 26; i++)
		{
			if(t1[i] != t2[i])
				return false;
		}

		return true;
	}

	public static int solve(BufferedReader br) throws Exception
	{
		int l = Integer.parseInt(br.readLine());

		String a = br.readLine();
		String b = br.readLine();

		int[][] dpa = new int[l+1][26];
		int[][] dpb = new int[l+1][26];

		fillCounts(dpa, a, l);
		fillCounts(dpb, b, l);

		int count = 0;
		int[] temp = new int[26]; 

		for(int i = 1; i <= l; i++)
		{
			for(int j = i; j <= l; j++)
			{
				for(int k = 0; k < 26; k++)
					temp[k] = dpa[j][k] - dpa[i-1][k];

				count += checkAnagram(dpb, temp, j-i, l);
			}
		}

		return count;
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