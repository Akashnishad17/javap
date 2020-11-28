import java.io.*;
import java.util.*;
import java.math.*;

class LargestSubNumber{

	public static int solve(int n , int k, String s)
	{
		StringBuilder sb = new StringBuilder(s);
		int max = -1;
		int xor = 0;
		BigInteger d = new BigInteger(String.valueOf(k));
		char c;
		for(int i = 0; i < n-1; i++)
		{
			c = s.charAt(i);
			sb.deleteCharAt(0);
			xor ^= Character.getNumericValue(c);
			BigInteger temp = new BigInteger(sb.toString());
			if((temp.mod(d)+"").equals("0"))
				max = Math.max(xor, max);
		}
		return max;
	} 

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			int res = solve(n, k, s);
			System.out.println(res);
		}
	}
}