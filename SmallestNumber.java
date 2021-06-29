import java.io.*;
import java.util.*;

class SmallestNumber{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		if(n == 1)
		{
			System.out.print(1);
			return;
		}

		int[] dp = new int[10];

		for(int i = 9; i >= 2; i--)
		{
			while(n % i == 0)
			{
				dp[i]++;
				n /= i;
			}
		}

		if(n > 1)
		{
			System.out.print("Not Possible");
			return;
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 2; i <= 9; i++)
		{
			while(dp[i] > 0)
			{
				dp[i]--;
				sb.append(i);
			}
		}

		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}