import java.io.*;
import java.util.*;

class BoringNumbers{

	public static long helper(long n)
	{
		String s = String.valueOf(n);
		int len = s.length();
		int digit, v;
		long res = 0, cur = 1;

		for(int i = 1; i < len; i++)
		{
			cur *= 5;
			res += cur;
		}

		long ok = 0, eq = 1, nok, neq;
		for(int i = 0; i < len; i++)
		{
			digit = s.charAt(i) - '0';

			if((i+1) % 2 == 0)
				v = digit/2 + 1;
			else
				v = (digit + 1)/2;

			nok = 0;
			neq = 0;
			nok += ok * 5;

			if(digit % 2 == (i+1) % 2)
			{
				--v;
				neq = eq;
			}

			nok += eq * v;

			ok = nok;
			eq = neq;

		}

		return res + ok + eq;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		
		long l = Long.parseLong(st[0]);
		long r = Long.parseLong(st[1]);

		return helper(r) - helper(l-1);
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