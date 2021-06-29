import java.io.*;
import java.util.*;

class WeirdAlgo{
	public static void solve(long n)
	{
		while(n != 1)
		{
			System.out.print(n+" ");
			if(n % 2 == 0)
				n /= 2;
			else
				n = n * 3 + 1;
		}

		System.out.print(1);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		long n = sc.nextLong();
		solve(n);
	}
}