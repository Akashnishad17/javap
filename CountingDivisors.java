import java.io.*;
import java.util.*;

class CountingDivisors{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int sqrt = (int)Math.sqrt(n);
		int count = 0;

		for(int i = 1; i <= sqrt; i++)
		{
			if(n % i == 0)
				count += 2;
		}	

		if(sqrt * sqrt == n)
			count--;

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}