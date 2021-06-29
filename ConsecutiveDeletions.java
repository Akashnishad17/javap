import java.io.*;
import java.util.*;

class ConsecutiveDeletions{
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		int[] arr = new int[n+1];

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
		{
			arr[i+1] = Integer.parseInt(st[i]);
			arr[i+1] += arr[i];
		}

		int total = arr[n];
		int min = n;

		for(int i = n; i >= k; i--)
			min = Math.min(min, arr[i] - arr[i-k]);

		return (((long)min) * (min + 1)) / 2 + total - min;
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