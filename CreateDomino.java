import java.io.*;
import java.util.*;

class CreateDomino{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		long sum = 0;

		for(int i = 1; i <= n; i++)
			sum += (i * (n - i + 1));

		System.out.println(sum);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}