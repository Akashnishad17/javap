import java.io.*;
import java.util.*;

class EvenPairSum{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long a = Long.parseLong(st[0]);
		long b = Long.parseLong(st[1]);

		long a_evens = a/2;
		long a_odds = (a+1)/2;

		long b_evens = b/2;
		long b_odds = (b+1)/2;

		long res = a_evens * b_evens + a_odds * b_odds;
		System.out.println(res);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}