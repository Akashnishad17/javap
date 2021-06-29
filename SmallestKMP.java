/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    String s = sc.next();
		    String pat = sc.next();
		    int[] dp = new int[26];
		    for(int i = 0; i < s.length(); i++)
		        dp[s.charAt(i)-'a']++;
		    for(int i = 0; i < pat.length(); i++)
		        dp[pat.charAt(i)-'a']--;
		    String ana = "";
		    int size;
		    for(int i = 0; i < 26; i++)
		    {
		        size = dp[i];
		        while(size-- > 0)
		            ana += (char)('a' + i);
		    }
		    boolean found = false;
		    int index = ana.length();
		    for(int i = 0; i < ana.length(); i++)
		    {
		        for(int j = i; j < ana.length() && j-i < pat.length(); j++)
		        {
		            if(ana.charAt(j) == pat.charAt(j-i))
		                continue;
		            if(ana.charAt(j) > pat.charAt(j-i))
		            {
		                found = true;
		                index = i;
		                break;
		            }
		            else
		                break;
		        }
		        if(found)
		            break;
		    }
		    String res = ana.substring(0,index) + pat + ana.substring(index,ana.length());
		    System.out.println(res);
		}
	}
}
