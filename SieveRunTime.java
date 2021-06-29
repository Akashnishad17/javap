import java.io.*;
import java.util.*;

class SieveRunTime{
	public static void solve(BufferedReader br) throws Exception
	{
		long n = Long.parseLong(br.readLine());

		long count = 0;

		for(long i = 1; i <= n; i++)
		{
			for(long j = 2*i; j <= n; j += i)
				count++;
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}