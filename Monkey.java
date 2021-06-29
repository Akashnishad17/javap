import java.io.*;
import java.util.*;

class Monkey{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int j = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());

		n -= m/k;
		n -= p/j;

		m %= k;
		p %= j;

		if(n == 1 && m > 0 && p > 0)
			n--;

		System.out.print(n);

	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt")); System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		while(t-- > 0)
			solve(br);
	}
}