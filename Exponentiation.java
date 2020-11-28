import java.io.*;
import java.util.*;

class Exponentiation{

	public static long power(long a, long b)
	{
		if(b == 0)
			return 1;

		long half = power(a, b/2);
		long half_prod = (half * half) % 1000000007;

		if(b % 2 == 0)
			return half_prod;

		return (half_prod * a) % 1000000007;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		return power(Long.parseLong(st[0]), Long.parseLong(st[1]));	
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.println(sb.toString());
	}
}