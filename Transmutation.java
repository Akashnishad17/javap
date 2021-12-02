import java.io.*;
import java.util.*;

class Transmutation{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long[] arr = new long[n+1];

		for(int i = 0; i < n; i++)
			arr[i+1] = Long.parseLong(st[i]);

		st = br.readLine().split(" ");

		int[] d = new int[n+1];

		for(int i = 0; i < n; i++)
			d[i+1] = Integer.parseInt(st[i]);

		long[] range = new long[n+1];

		long max = 0;

		for(int i = 1; i <= n; i++)
		{
			range[i] += arr[i] + range[i-1];

			if(i + d[i] <= n)
				range[i + d[i]] -= arr[i];

			max = Math.max(max, range[i]);
		}

		return max;
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}