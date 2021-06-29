import java.io.*;
import java.util.*;

class DivisbleBy8{
	public static boolean solve(char[] s, int l, int r)
	{
		if(l == r)
		{
			int num = 0;

			for(char c : s)
				num = num * 10 + (c - '0');

			return num % 8 == 0;
		}

		for(int i = l; i <= r; i++)
		{
			swap(s, l, i);
			if(solve(s, l+1, r))
				return true;
			swap(s, l, i);
		}

		return false;
	}

	public static void swap(char[] s, int l, int r)
	{
		char c = s[l];
		s[l] = s[r];
		s[r] = c;
	}

	public static void main(String[] args)
	{
		char[] s = new Scanner(System.in).nextLine().toCharArray();
		System.out.print(solve(s, 0, s.length-1));
	}
}