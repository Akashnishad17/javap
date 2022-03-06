import java.io.*;
import java.util.*;

class ParallelProcessing{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		long[] arr = new long[n];

		String[] st = br.readLine().split(" ");

		long sum = 0;

		for(int i = 0; i < n; i++)
		{
			arr[i] = Long.parseLong(st[i]);
			sum += arr[i];
		}

		long min = sum;

		long cur = 0;

		for(int i = 0; i < n; i++)
		{
			cur += arr[i];
			min = Math.min(min, Math.max(cur, sum - cur));
		}

		return min;
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