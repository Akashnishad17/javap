import java.io.*;
import java.util.*;

class RemovalGame{

	static long[][] dp;
	static boolean[][] visited;
	
	public static long solve(int[] arr, int left, int right, boolean flag)
	{
		if(left == right)
			return flag ? arr[left] : 0;

		if(visited[left][right])
			return dp[left][right];

		long d1 = (flag ? arr[left] : 0) + solve(arr, left+1, right, !flag);
		long d2 = (flag ? arr[right] : 0) + solve(arr, left, right-1, !flag);

		visited[left][right] = true;
		long max = d1 > d2 ? d1 : d2;
		long min = d1 < d2 ? d1 : d2;

		return dp[left][right] = (flag ? max : min);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];

		for(int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		dp = new long[n+1][n+1];
		visited = new boolean[n+1][n+1];

		System.out.println(solve(arr, 1, n, true));
	}
}