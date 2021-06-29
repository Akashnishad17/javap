import java.io.*;
import java.util.*;

class InterestingXOR{
	public static long solve(BufferedReader br) throws Exception
	{
		int c = Integer.parseInt(br.readLine());

		int[] bits = new int[31];

		int i;

		for(i = 0; i < 31 && c > 0; i++)
		{
			bits[i] = c % 2;
			c /= 2;
		}

		long a = 0, b = 0;

		boolean first = true;

		for(int j = i - 1; j >= 0; j--)
		{
			if(bits[j] == 0)
			{
				a += 1 << j;
				b += 1 << j;
			}
			else
			{
				if(first)
				{
					a += 1 << j;
					first = false;
				}
				else
					b += 1 << j;
			}
		}

		return a * b;
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