import java.io.*;
import java.util.*;

class CollectingNumbers{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		boolean[] dp = new boolean[n+1];

		int count = 0, x;

		String[] st = br.readLine().split(" ");

		for(String s : st)
		{
			x = Integer.parseInt(s);
			if(!dp[x-1])
				count++;

			dp[x] = true;
		}

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}