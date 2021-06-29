import java.io.*;
import java.util.*;

class HugeNumbers{

	public static long pow(long a, long n, long p)
	{
		if(n == 0)
			return 1;

		long half = pow(a, n/2, p);
		long half_sq = (half * half) % p;

		if(n % 2 == 0)
			return half_sq;

		return (half_sq * a) % p;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		long a = Long.parseLong(st[0]);
		long n = Long.parseLong(st[1]);
		long p = Long.parseLong(st[2]);

		long ans = a % p;

		for(int i = 2; i <= n; i++)
			ans = pow(ans, i, p);
		
		return ans;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}