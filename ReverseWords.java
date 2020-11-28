import java.io.*;
import java.util.*;

class ReverseWords{

	public static void reverse(char[] chars, int l, int r)
	{
		char c;
		while(l < r)
		{
			c = chars[l];
			chars[l] = chars[r];
			chars[r] = c;
			l++;
			r--;
		}
	}

	public static String solve(BufferedReader br) throws Exception
	{
		char[] chars = br.readLine().toCharArray();

		int l = 0, r = 0;
		int n = chars.length;

		while(l < n && r < n)
		{
			if(chars[r] == ' ')
			{
				reverse(chars, l, r-1);
				l = r + 1;
				r = l;
			}
			else
				r++;
		}

		reverse(chars, l, r-1);
		reverse(chars, 0, n-1);

		return new String(chars);
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