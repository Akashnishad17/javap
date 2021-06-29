import java.io.*;
import java.util.*;

class RationalBinary{

	public static HashSet<String> set;
	static{
		set = new HashSet<>();

		long x = 2;
		set.add("1 2");

		int count = 3;

		while(count < 64)
		{
			x *= 2;
			set.add("1 "+x);
			set.add((x-1)+" "+x);
			count++;
		}
	}

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long a = Long.parseLong(st[0]);
		long b = Long.parseLong(st[1]);

		return set.contains(a+" "+b) ? "Yes" : "No";
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