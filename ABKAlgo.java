import java.io.*;
import java.util.*;

class ABKAlgo{

	/*	res = a
		for i = 1 to k:
			if i is odd:
				res = res & b
			else
				res = res | b
		return res*/

	public static long bruteForce(long a, long b, long k)
	{
		long res = a;

		for(int i = 1; i <= k; i++)
		{
			if(i % 2 == 1)
				res &= b;
			else
				res |= b;
		}

		return res;
	}

	public static long greedy(long a, long b, long k)
	{
		if(k == 1)
			return a & b;

		return (a & b) | b;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		long a = Long.parseLong(br.readLine());
		long b = Long.parseLong(br.readLine());
		long k = Long.parseLong(br.readLine());

		long res1 = bruteForce(a, b, k);
		long res2 = greedy(a, b, k);

		System.out.println(res1+" "+res2); 
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}