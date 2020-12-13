import java.io.*;
import java.util.*;

class AllUniqueStrings{

	public static String reverse(String s)
	{
		String res = "";

		for(int i = 0; i < s.length(); i++)
			res = s.charAt(i) + res;

		return res;
	}
	
	public static int solve(String s)
	{
		HashSet<String> set = new HashSet<>();
		String t;

		for(int i = 0; i < s.length(); i++)
		{
			t = s.substring(i, s.length()) + s.substring(0,i);
			
			set.add(t);
			set.add(reverse(t));
		}

		return set.size();
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		String s = br.readLine();
		System.out.print(solve(s));
	}
}