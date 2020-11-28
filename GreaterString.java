import java.io.*;
import java.util.*;

class GreaterString{

	public static  void swap(char[] chars,int i, int j)
	{
		char c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
	}

	public static void reverse(char[] chars, int l, int r)
	{
		while(l < r)
		{
			swap(chars, l, r);
			l++;
			r--;
		}
	}

	public static void solve(Scanner sc)
	{
		String s = sc.next();
		char[] chars = s.toCharArray();

		int len = chars.length;
		int i = len-1;
		
		while(i > 0)
		{
			if(chars[i] > chars[i-1])
				break;
			i--;
		}

		if(i <= 0)
		{
			System.out.println("no answer");
			return;
		}

		int j = len-1;

		while(j >= i)
		{
			if(chars[i-1] < chars[j])
				break;
			j--;
		}

		swap(chars, i-1, j);

		reverse(chars, i, len-1);

		System.out.println(new String(chars));

	}

	public static void main(String[] args) throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = sc.nextInt();
		while(t-- > 0)
			solve(sc);
	}
}