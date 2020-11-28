import java.io.*;
import java.util.*;

class BookReading{

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
		int q = Integer.parseInt(st[2]);

		st = br.readLine().split(" ");
		HashSet<Integer> set = new HashSet<>();

		for(int i = 0; i < m; i++)
			set.add(Integer.parseInt(st[i]));

		int[] dp = new int[n+1];

		for(int i = 1; i <= n; i++)
		{
			for(int j = i; j <= n; j += i)
			{
				if(!set.contains(j))
					dp[i]++;
			}
		}

		long count = 0;
		st = br.readLine().split(" ");

		for(int i = 0; i < q; i++)
			count += dp[Integer.parseInt(st[i])];

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