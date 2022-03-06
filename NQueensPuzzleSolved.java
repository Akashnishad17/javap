import java.io.*;
import java.util.*;

class NQueensPuzzleSolved{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		if(n <= 6)
			return 0;

		double x = 0.143 * n;

		double res = 1.0;

		while(n-- > 0)
			res *= x;

		return (long)Math.floor(res) + (res - Math.floor(res) < 0.5 ? 0 : 1);
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