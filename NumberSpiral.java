import java.io.*;
import java.util.*;

class NumberSpiral{
	public static void solve(Scanner sc)
	{
		long x = sc.nextLong();
		long y = sc.nextLong();
		long res = 0;
		
		if(x == y)
			res = 1 + x * (x -1);

		else if(x < y)
		{
			if(y % 2 == 0)
				res = (y - 1) * (y - 1) + x;
			else
				res = y * y - x + 1;
		}

		else
		{
			if(x % 2 == 0)
				res = x * x - y + 1;
			else
				res = (x - 1) * (x - 1) + y;
		}

		System.out.println(res);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		int t = sc.nextInt();
		while(t-- > 0)
			solve(sc);
	}
}