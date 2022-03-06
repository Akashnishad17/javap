import java.io.*;
import java.util.*;

class BinaryBaseBasics{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		String s = br.readLine();

		int l = 0, r = s.length() - 1;

		while(l < r)
		{
			if(s.charAt(l) != s.charAt(r))
			{
				if(k > 0)
					k--;
				else
					break;
			}

			l++;
			r--;
		}	

		if(k == 0 && l < r)
			return "NO";

		if(k % 2 == 1)
			return s.length() % 2 == 1 ? "YES" : "NO";

		return "YES";
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