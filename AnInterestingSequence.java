import java.io.*;
import java.util.*;

class AnInterestingSequence{

	public static int n = 4000005;
	public static int[] dp, res;

	static{

		dp = new int[n];
		res = new int[n];

		for(int i = 0; i < n; i++)
			dp[i] = i;

		for(int p = 2; p < n; p++)
		{
			if(dp[p] == p)
			{
				dp[p] = p - 1;

				for(int i = 2*p; i < n; i += p)
					dp[i] = (dp[i] / p) * (p - 1);
			}
		}

		for(int i = 1; i < n; i++)
		{
			res[i] += i - 1;

			for(int j = 2 * i; j < n; j += i)
				res[j] += i * ((1 + dp[j/i]) / 2);
		}
	}

	public static int solve(BufferedReader br) throws Exception
	{
		int k = Integer.parseInt(br.readLine());

		return res[4*k + 1];
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