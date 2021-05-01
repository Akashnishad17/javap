import java.io.*;
import java.util.*;

class AverageSorting{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		if(n == 2)
			return arr[0] < arr[1] ? "Yes" : "No";

		boolean[] dp = new boolean[n];

		int min = Integer.MAX_VALUE;

		for(int i = 0; i < n-1; i++)
		{
			if(arr[i] >= arr[i+1])
			{
				if(min < arr[i+1])
				{
					dp[i] = true;
					dp[i+1] = true;
				}
			}
			else
			{
				dp[i] = true;
				dp[i+1] = true;
			}

			min = Math.min(min, arr[i]);
		}

		int max = Integer.MIN_VALUE;

		for(int i = n - 1; i > 0; i--)
		{
			if(arr[i-1] >= arr[i])
			{
				if(arr[i-1] < max)
				{
					dp[i-1] = true;
					dp[i] = true;
				}
			}
			else
			{
				dp[i-1] = true;
				dp[i] = true;
			}

			max = Math.max(max, arr[i]);
		}

		for(int i = 0; i < n; i++)
		{
			if(!dp[i])
				return "No";
		}

		return "Yes";
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