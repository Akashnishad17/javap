import java.io.*;
import java.util.*;

class SherlockAndParenthesis{
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		long l = Long.parseLong(st[0]);
		long r = Long.parseLong(st[1]);
		
		long x = Math.min(l, r);

		return (x * (x + 1))/2;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}