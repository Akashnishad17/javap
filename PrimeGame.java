import java.io.*;
import java.util.*;

class PrimeGame{

	static int[] dp;

	static{

		dp = new int[1000001];

		Arrays.fill(dp, 1);

		dp[0] = 0;
		dp[1] = 0;

		for(int i = 2; i <= 1000; i++)
		{
			if(dp[i] == 1)
			{
				for(int j = i*i; j <= 1000000; j += i)
					dp[j] = 0;
			}
		}

		for(int i = 1; i <= 1000000; i++)
			dp[i] += dp[i-1];
	}

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int x = Integer.parseInt(st[0]);
		int y = Integer.parseInt(st[1]);

		if(x == 1)
			return "Chef";

		if(dp[x] <= y)
			return "Chef";

		return "Divyam";
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