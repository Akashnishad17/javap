import java.io.*;
import java.util.*;

class Candlelight{
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long a = Long.parseLong(st[0]);
		long y = Long.parseLong(st[1]);
		long x = Long.parseLong(st[2]);

		if(a < y)
		{
			return a * x + 1;
		}
		else
			return y * x;
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