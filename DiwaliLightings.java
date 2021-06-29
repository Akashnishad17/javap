import java.io.*;
import java.util.*;

class DiwaliLightings{
	public static long solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();
		
		String[] st = br.readLine().split(" ");
		long l = Long.parseLong(st[0]);
		long r = Long.parseLong(st[1]);
		l--;

		int n = s.length();
		int[] dp = new int[n+1];

		for(int i = 1; i <= n; i++)
			dp[i] = dp[i-1] + (s.charAt(i-1) == 'B' ? 1 : 0);

		long offset = l/n;
		l -= offset*n;
		r -= offset*n;

		offset = r/n - (r % n == 0 ? 1 : 0);
		r = (r - 1) % n + 1;
		
		return dp[(int)r] - dp[(int)l] + offset*dp[n];
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