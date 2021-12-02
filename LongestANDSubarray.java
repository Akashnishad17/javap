import java.io.*;
import java.util.*;

class LongestANDSubarray{
	public static long solve(BufferedReader br) throws Exception
	{
		long n = Long.parseLong(br.readLine());

		if(n == 1)
			return 1;

		long pow = 1, max = 1;

		while(pow*2 < n)
		{
			max = pow;
			pow *= 2;		
		}

		return Math.max(max, n - pow  + (pow * 2 != n ? 1 : 0));
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