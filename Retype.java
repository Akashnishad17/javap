import java.io.*;
import java.util.*;

class Retype{

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		
		long n = Long.parseLong(st[0]);
		long k = Long.parseLong(st[1]);
		long s = Long.parseLong(st[2]);

		return Math.min(n+k, n + 2*(k - s));
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}