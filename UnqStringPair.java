import java.io.*;
import java.util.*;

class UnqStringPair{

	public static boolean containsChar(String a, String b)
	{
		int[] dp = new int[26];
		for(int i = 0; i < b.length(); i++)
			dp[b.charAt(i) - 'a'] = 1;
		for(int i = 0;  i < a.length(); i++)
		{
			if(dp[a.charAt(i) - 'a'] == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] str = s.split(",");
		int count = 0;
		for(int i = 0; i < str.length-1; i++)
		{
			for(int j = i + 1; j < str.length; j++)
			{
				if(containsChar(str[i],str[j]) || containsChar(str[j],str[i]))
					count++;
			}
		}
		if(count == 0)
			count = -1;
		System.out.print(count);
	}
}