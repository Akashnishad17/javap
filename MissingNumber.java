import java.io.*;
import java.util.*;

class MissingNumber{
	public static void solve(long n, Scanner sc)
	{
		long sum = 0;
		for(long i = 1; i < n; i++)
			sum += sc.nextLong();

		System.out.print((n*(n+1))/2 - sum);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		long n = sc.nextLong();
		solve(n, sc);
	}
}