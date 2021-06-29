import java.io.*;
import java.util.*;

class WrongNumber{
	public static String solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		if(s.charAt(0) == '1')
			return "10" + s.substring(1, s.length());

		return "1" + s;
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