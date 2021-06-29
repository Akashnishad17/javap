import java.io.*;
import java.util.*;

class RSA{

	public static long gcd(long a, long b)
	{
		return a == 0 ? b : gcd(b % a, a);
	} 
	
	public static void solve(BufferedReader br) throws Exception
	{
		long p = Long.parseLong(br.readLine()); // first prime
		long q = Long.parseLong(br.readLine()); // second prime
		double msg = Double.parseDouble(br.readLine()); // plain text

		double n = p * q;
		double phi = (p-1) * (q-1);

		double e = 2; // 1 < e < phi and gcd(e,phi) == 1

		while(e < phi && gcd((long)e, (long)phi) != 1)
			e++;

		double d = (1.0 / e) % phi; // inverse modulas


		// by formula p ^ e % n and c ^ d % n
		double temp1 = Math.pow(msg, e);
		double temp2 = Math.pow(temp1, d);

		double encrypted = temp1 % n;
		double decrypted = Math.round(temp2 % n);

		System.out.println("n: "+n);
		System.out.println("phi: "+phi);
		System.out.println("e: "+e);
		System.out.println("d: "+d);
		System.out.println("Plain Text: "+msg);
		System.out.println("Encrypted message: "+encrypted);
		System.out.println("Decrypted message: "+decrypted);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}