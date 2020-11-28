import java.io.*;
import java.util.*;

class CovidRun{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int[] dp = new int[n];

		while(dp[x] == 0)
		{
			dp[x] = 1;
			x = (x + k)%n;
		}

		System.out.println(dp[y] == 1 ? "YES" : "NO"); 	
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
			solve(sc);
	}
}