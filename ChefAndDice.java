import java.io.*;
import java.util.*;

class ChefAndDice{

	// 1 -> 20
	// 2 -> 18 + 18 = 36
	// 3 -> 18 + 18 + 15 = 51
	// 4 -> 15 + 15 + 15 + 15 = 60
	// 11*4 = 44 + 4*(4 - (n - 1) % 4 + 1)

	public static long solve(BufferedReader br) throws Exception
	{
		long n = Long.parseLong(br.readLine());

		if(n <= 4)
			return helper(n);

		long total = 44 * (n/4 - (n % 4 == 0 ? 1 : 0));
		long left = (n - 1) % 4 + 1;

		total += helper(left);
		total += 4 * (4 - left);

		return total;
	}

	public static int helper(long n)
	{
		if(n == 1)
			return 20;

		if(n == 2)
			return 36;

		if(n == 3)
			return 51;

		return 60;
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