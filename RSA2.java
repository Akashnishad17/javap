import java.io.*;
import java.util.*;

class RSA2{

	public static long gcd(long a, long b)
	{
		return a == 0 ? b : gcd(b % a, a);
	} 

	public static long inverse(long e, long phi)
	{
		for(int i = 1; i <= phi; i++)
		{
			if((i * e) % phi == 1)
				return i;
		}

		return 1;
	}

	public static long pow(long a, long x, long m)
	{
		if(x == 0)
			return 1;

		long half = pow(a, x/2, m);
		long half_prod = (half * half) % m;

		if(x % 2 == 0)
			return half_prod;
		else
			return (half_prod * a) % m;
	}
	
	public static void solve(BufferedReader br) throws Exception
	{
		long p = Long.parseLong(br.readLine()); // first prime
		long q = Long.parseLong(br.readLine()); // second prime
		Long msg = Long.parseLong(br.readLine()); // plain text

		long n = p * q;
		long phi = (p-1) * (q-1);

		long e = 2; // 1 < e < phi and gcd(e,phi) == 1

		while(e < phi && gcd(e, phi) != 1)
			e++;

		e = 7;

		long d = inverse(e, phi); // inverse modulas


		// by formula p ^ e % n and c ^ d % n
		long encrypted = pow(msg, e, n);
		long decrypted = pow(encrypted, d, n);

		System.out.println("n: "+n);
		System.out.println("phi: "+phi);
		System.out.println("e: "+e);
		System.out.println("d: "+d);
		System.out.println("Plain Text: "+msg);
		System.out.println("Encrypted message: "+encrypted);
		System.out.println("Decrypted message: "+decrypted);

		System.out.println(inverse(15, 26));
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}