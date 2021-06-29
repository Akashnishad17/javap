import java.io.*;
import java.util.*;

class Racing{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		long x = Long.parseLong(st[0]);
		long r = Long.parseLong(st[1]) * 60;
		long m = Long.parseLong(st[2]) * 60;

		if(r > m)
			return "NO";

		if(x >= r)
			return "YES";

		return r - x <= m - r ? "YES" : "NO";
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