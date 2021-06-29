import java.io.*;
import java.util.*;

class BitwiseTuples{

	public static int[] arr;
	public static int mod = 1000000007;
	static{
		int max = 1000000;
		arr = new int[max+1];

		arr[0] = 1;

		for(int i = 1; i <= max; i++)
			arr[i] = (arr[i-1] * 2) % mod;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		return power(arr[n] - 1, m);
	}

	public static long power(long a, int b)
	{
		if(b == 0)
			return 1;

		long half = power(a, b/2);
		long half_prod = (half * half) % mod;

		if(b % 2 == 0)
			return half_prod;

		return (half_prod * a) % mod;
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