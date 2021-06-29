import java.io.*;
import java.util.*;

class CommonDivisors{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] dp = new int[1000001];
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		for(int x : arr)
		{
			int sqrt = (int)Math.sqrt(x);

			for(int i = 1; i <= sqrt; i++)
			{
				if(x % i == 0)
				{
					dp[i]++;
					dp[x/i]++;
				}
			}

			if(sqrt * sqrt == x)
				dp[sqrt]--;
		}

		int max = 1;

		for(int i = 2; i <= 1000000; i++)
		{
			if(dp[i] >= 2)
				max = i;
		}

		return max;
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}