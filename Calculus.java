import java.io.*;
import java.util.*;

class Calculus{

	public static long mod = 998244353;

	public static long pow(long a, long b)
	{
		a %= mod;
		long res = 1;

		while(b > 0)
		{
			if((b & 1) > 0)
				res = (res * a) % mod;

			a = (a * a) % mod;
			b >>= 1;
		}

		return res;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		long n = Long.parseLong(br.readLine());
		long res = 1, in = 3;

		for(int i = 2; i <= n; i++)
		{
			res += pow(in, mod - 2);
			res %= mod;
			in += 2;
		}

		res = (2 * res) % mod;

		System.out.print(res);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}