import java.io.*;
import java.util.*;

class AirlineRestrictions{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int a = Integer.parseInt(st[0]);
		int b = Integer.parseInt(st[1]);
		int c = Integer.parseInt(st[2]);
		int d = Integer.parseInt(st[3]);
		int e = Integer.parseInt(st[4]);

		return (a <= e && (b + c) <= d) || (b <= e && (a + c) <= d) || (c <= e && (a + b) <= d) ? "Yes" : "No";
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