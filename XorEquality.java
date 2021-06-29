import java.io.*;
import java.util.*;

class XorEquality{

	public static long[] pow;
	public static int mod = 1000000007;
	public static int max = 100000;

	static{
		pow = new long[max+1];
		pow[0] = 1;

		for(int i = 1; i <= max; i++)
			pow[i] = (pow[i-1] * 2) % mod;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		return pow[n-1];
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