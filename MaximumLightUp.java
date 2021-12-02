import java.io.*;
import java.util.*;

class MaximumLightUp{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long p = Long.parseLong(st[0]);
		long a = Long.parseLong(st[1]);	
		long b = Long.parseLong(st[2]);	
		long c = Long.parseLong(st[3]);	
		long x = Long.parseLong(st[4]);	
		long y = Long.parseLong(st[5]);

		long cost1 = a * x + b;
		long cost2 = a * y + c;

		return (int)(cost1 < cost2 ? p / cost1 : p / cost2);
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