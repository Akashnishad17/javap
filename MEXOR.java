import java.io.*;
import java.util.*;

class MEXOR{
	public static long solve(BufferedReader br) throws Exception
	{
		long n = Long.parseLong(br.readLine());

		if(n == 0 || n == 1)
			return n + 1;

		long pow = 1;

		while(pow * 2 <= n)
			pow *= 2;

		if(pow * 2 == n + 1)
			pow *= 2;

		return pow;
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