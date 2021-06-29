import java.io.*;
import java.util.*;

class PrimeTuples{

	public static int[] dp;
	public static int[] pairs;

	public static void pre()
	{
		dp = new int[1000001];
		pairs = new int[1000001];

		Arrays.fill(dp, 1);

		dp[0] = 0;
		dp[1] = 0;

		for(int i = 2; i <= 1000000; i++)
		{
			if(dp[i] == 1)
			{
				if(i <= 1000)
				{
					for(int j = i*i; j <= 1000000; j += i)
						dp[j] = 0;
				}

				if(dp[i-2] == 1)
					pairs[i]++;

			}
		}

		for(int i = 5; i <= 1000000; i++)
			pairs[i] += pairs[i-1];
	}

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		return pairs[n];
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));

		pre();
		
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}