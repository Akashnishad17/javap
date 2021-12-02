import java.io.*;
import java.util.*;

class AddandDivide{

	public static long gcd(long a, long b)
	{
		return a == 0 ? b : gcd(b % a, a);
	}

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long a = Long.parseLong(st[0]);
		long b = Long.parseLong(st[1]);

		if(a == b)
			return "YES";

		if(a == 1)
			return "YES";

		if(b == 1)
			return "NO";

		long gcd = gcd(a, b);
	
		if(gcd == 1)
			return "NO";

		long lcm = (a * b) / gcd;

		while(true)
		{
			a = lcm / b;

			if(a == 1)
				break;
			
			gcd = gcd(a, b);

			if(gcd == 1)
				return "NO";

			if(lcm == (a * b) / gcd)
				break;

			lcm = (a * b) / gcd;
		}

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