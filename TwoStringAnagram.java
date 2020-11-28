import java.io.*;
import java.util.*;

class TwoStringAnagram{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		int res = solve(s, t);
		System.out.print(res);
	}
	
	public static int solve(String s, String t)
	{
		int[] dp = new int[26];
		for(int i = 0; i < s.length(); i++)
		{
			dp[s.charAt(i)-'a']++;
			dp[t.charAt(i)-'a']--;
		}
		int min = 0;
		for(int x : dp)
			min += Math.abs(x);
		return min/2;
	}
}