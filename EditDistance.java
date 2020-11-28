import java.io.*;
import java.util.*;

class EditDistance{

	public static int[][] dp = new int[5001][5001];
	
	public static int solve(int i, int j, String s1, String s2)
	{
		if(i == s1.length() || j == s2.length())
			return Math.max(s1.length()-i, s2.length() - j);
		
		if(dp[i][j] != -1)
			return dp[i][j];

		int ans = 0;
		
		if(s1.charAt(i) == s2.charAt(j))
			ans = solve(i+1, j+1, s1, s2);
		else
		{
			int d1 = solve(i+1, j, s1, s2);
			int d2 = solve(i, j+1, s1, s2);
			int d3 = solve(i+1, j+1, s1, s2);
			ans = 1 + Math.min(d1,Math.min(d2, d3));
		}

		return dp[i][j] = ans;
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		String s1 = sc.next();
		String s2 = sc.next();
		for(int[] d : dp)
			Arrays.fill(d, -1);
		System.out.print(solve(0, 0, s1, s2));
	}
}