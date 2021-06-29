import java.io.*;
import java.util.*;

class CreateString{

	public static TreeSet<String> set = new TreeSet<>();
	
	public static void permute(char[] chars, int l, int r)
	{
		if(l == r)
		{
			set.add(new String(chars));
			return;
		}

		for(int i = l; i <= r; i++)
		{
			swap(chars, i, l);
			permute(chars, l+1, r);
			swap(chars, i, l);
		}
	}

	public static void swap(char[] chars, int l, int r)
	{
		char c = chars[l];
		chars[l] = chars[r];
		chars[r] = c;
	}

	public static void solve(Scanner sc)
	{
		char[] chars = sc.next().toCharArray();
		permute(chars, 0, chars.length-1);

		System.out.println(set.size());
		for(String s : set)
			System.out.println(s);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));

		solve(sc);
	}
}