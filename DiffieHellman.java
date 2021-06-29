import java.io.*;
import java.util.*;

class DiffieHellman{

	public static long power(long g, long x, long p)
	{
		if(x == 0)
			return 1;

		long half = power(g, x/2, p);
		long half_product = (half * half) % p;

		if(x % 2 == 0)
			return half_product;
		else
			return (half_product * g) % p;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		long p = Integer.parseInt(st[0]);
		long g = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		long x = Integer.parseInt(st[0]);
		long y = Integer.parseInt(st[1]);

		// g^x % p && g^y % p;
		long a = power(g, x, p);
		long b = power(g, y, p);

		// b^x % p == a^y % p;
		long k1 = power(b, x, p);
		long k2 = power(a, y, p);

		// k1 and k2 are equal shared same secret key
		System.out.println(a+" "+b);
		System.out.print(k1+" "+k2);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}