import java.io.*;
import java.util.*;

class ProfitMaximization{
	
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		String[] st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int[] dp = new int[n];
		for(int i = 0; i < n; i++)
			dp[i] = arr[i];

		for(int i = 0; i < n-1; i++)
		{
			for(int j = i+1; j < n; j++)
			{
				if(arr[j] % arr[i] == 0)
					dp[j] = Math.max(dp[j], dp[i] + arr[j]);
			}
		}

		int max = 0;

		for(int i = 0; i < n; i++)
			max = Math.max(max, dp[i]);

		System.out.print(max);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}