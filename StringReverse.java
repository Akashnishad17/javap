import java.io.*;
import java.util.*;

class StringReverse{
	public static int solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		int n = s.length();

		int i = 0, j = n - 1;

		while(i < n)
		{
			if(s.charAt(i) == s.charAt(j))
				j--;
			
			i++;
		}

		return j + 1;
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}