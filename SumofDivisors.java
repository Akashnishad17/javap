import java.io.*;
import java.util.*;

class SumofDivisors{

	public static long solve(BufferedReader br) throws Exception
	{
		long n = Long.parseLong(br.readLine());
		long sqrt = (int)Math.sqrt(n);

		long sum = 0;

		for(int i = 1; i <= sqrt; i++)
		{
			if(n % i == 0)
			{
				sum += i + n/i;
				sum %= 1000000007;
			}
		}

		if(sqrt * sqrt == n)
			sum = (sum - sqrt + 1000000007) % 1000000007;

		return sum;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}