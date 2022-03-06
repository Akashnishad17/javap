import java.io.*;
import java.util.*;

class FixedWeight {
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long n = Long.parseLong(st[0]);
		long x = Long.parseLong(st[1]);

		long i = 1;

		while(i <= n)
		{
			if(x % i == 0)
			{
				if(i + x / i - 1 <= n)
					return "YES";
			}
			i++;
		}
		return "NO";
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