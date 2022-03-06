import java.io.*;
import java.util.*;

class PermutationXORSum{
	public static long solve(BufferedReader br) throws Exception
	{
		long n = Long.parseLong(br.readLine());

		long res = 0;

		while(n > 1)
		{
			int bit = highest(n);
			long score = (1l << bit) - 1;
			long count = n + 1 - (1l << (bit - 1));
			res += (2 * (count - (score == n ? 1 : 0))) * score;
			n -= 2 * count;
		}

		return res;
	}

	public static int highest(long n)
	{
		int count = 0;

		while(n > 0)
		{
			count++;
			n /= 2;
		}

		return count;
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