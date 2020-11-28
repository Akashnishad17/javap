import java.io.*;
import java.util.*;

class LargestEven{

	public static int getMinEvenIndex(int[] dp)
	{
		for(int i = 0; i < 10; i += 2)
		{
			if(dp[i] == 1)
				return i;
		}
		return -1;
	} 

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] dp = new int[10];
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
				dp[s.charAt(i) - '0'] = 1;
		}
		int index = getMinEvenIndex(dp);
		if(index == -1)
			System.out.println(-1);
		else
		{
			int num = 0;
			int p = 1;
			for(int i = 0; i < 10; i++)
			{
				if(index == i)
					continue;
				if(dp[i] == 1)
				{
					num +=  p*i;
					p *= 10;
				}
			}
			num *= 10;
			num += index;
			System.out.println(num);
		}
	}
}