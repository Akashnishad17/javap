import java.io.*;
import java.util.*;

class ArrayRotation{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long sum = 0, val;
		int mod = 1000000007;

		int q = Integer.parseInt(br.readLine());

		br.readLine();

		for(int i = 0; i < n; i++)
		{
			val = Long.parseLong(st[i]);

			sum += val;

			while(sum < 0)
				sum += mod;

			sum %= mod;
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < q; i++)
		{
			sum = (sum * 2) % mod;
			sb.append(sum+"\n");
		}

		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}