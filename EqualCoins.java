import java.io.*;
import java.util.*;

class EqualCoins{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long x = Long.parseLong(st[0]);
		long y = Long.parseLong(st[1]);

		String res = x % 2 == 0 && (y % 2 == 0 || x > 0) ? "Yes" : "No";

		return res;
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