import java.io.*;
import java.util.*;

class MathEncoder{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		long[] pows = new long[n];
		pows[0] = 1;

		long count = 0;

		for(int i = 1; i < n; i++)
			pows[i] = (pows[i-1] * 2) % 1000000007;

		for(int i = 0; i < n-1; i++)
		{
			for(int j = i + 1; j < n; j++)
			{
				count = count + (pows[(j - i - 1)] * (arr[j] - arr[i])) % 1000000007;
				count %= 1000000007;
			}
		}

		return count;
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