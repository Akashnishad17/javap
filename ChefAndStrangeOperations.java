import java.io.*;
import java.util.*;

class ChefAndStrangeOperations{

	public static final int mod = 1000000007;

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);
		long m = Long.parseLong(st[2]);

		st = br.readLine().split(" ");

		long[] arr = new long[n+1];

		for(int i = 0; i < n; i++)
			arr[i+1] = Long.parseLong(st[i]);

		long res = arr[x] % mod;

		long cur = m;

		for(int i = x - 1; i > 0; i--)
		{
			res = (res + ((arr[i] % mod) * (m % mod)) % mod) % mod;
			m += (cur % mod);
			cur = ((cur % mod) + 1) % mod;
		}

		return res;
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}