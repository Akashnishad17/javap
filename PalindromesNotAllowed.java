import java.io.*;
import java.util.*;

class PalindromesNotAllowed{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while(n-- > 0)
		{
			if(n % 3 == 1)
				sb.append('a');
			else if(n % 3 == 2)
				sb.append('b');
			else
				sb.append('c');
		}

		return sb.toString();
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