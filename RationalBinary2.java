import java.io.*;
import java.util.*;

class RationalBinary2{

	public static HashSet<Long> set;
	static{
		set = new HashSet<>();

		long x = 1;
		int count = 1;

		while(count < 64)
		{
			set.add(x);
			x *= 2;
			count++;
		}
	}

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long a = Long.parseLong(st[0]);
		long b = Long.parseLong(st[1]);

		while(b % 5 == 0)
			b /= 5;

		return set.contains(b) ? "Yes" : "No";
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