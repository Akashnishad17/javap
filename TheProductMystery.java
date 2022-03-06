import java.io.*;
import java.util.*;

class TheProductMystery{
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long b = Long.parseLong(st[0]);
		long c = Long.parseLong(st[1]);

		return c / gcd(b, c);
	}

	public static long gcd(long a, long b)
	{
		return a == 0 ? b : gcd(b % a, a);
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