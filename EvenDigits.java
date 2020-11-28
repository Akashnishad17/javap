import java.io.*;
import java.util.*;

class EvenDigits{

	public static long nextSmallerDifference(long n)
	{
		long temp = n;
		long pow = 10000000000000000L;
		int i;

		for(i = 16; i >= 0; i--)
		{
			if(((temp / pow) % 10) % 2 != 0)
				break;

			pow /= 10;
		}

		if(i == -1)
			return 0;

		temp /= pow;
		temp--;

		while(i-- > 0)
			temp = temp*10 + 8;

		return n - temp;
	}

	public static long nextGreaterDifference(long n)
	{
		long temp = n;
		long pow = 10000000000000000L;
		int i;

		for(i = 16; i >= 0; i--)
		{
			if(((temp / pow) % 10) % 2 != 0)
				break;

			pow /= 10;
		}

		if(i == -1)
			return 0;

		temp /= pow;

		long t = 0;
		long p = 1;
		
		while(temp > 0)
		{
			if((temp % 10) % 2 != 0)
				temp++;

			t += (temp % 10) * p;
			temp /= 10;
			p *= 10;
		}

		while(i-- > 0)
			t *= 10;

		return t - n;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		long n = Long.parseLong(br.readLine());
		long x = nextSmallerDifference(n);
		long y = nextGreaterDifference(n);

		return Math.min(x,y);
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