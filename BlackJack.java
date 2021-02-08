import java.io.*;
import java.util.*;

class BlackJack{

	public static int[][] dp;

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);
		int y = Integer.parseInt(st[2]);

		int[] arr = new int[n];
		st = br.readLine().split(" ");

		int sum = 0;

		for(int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(st[i]);

			if(arr[i] <= y)
				sum += arr[i];
		}

		if(sum < x)
			return -1;

		dp = new int[n+1][y+1];

		for(int i = 0; i < n; i++)
			Arrays.fill(dp[i], -2);

		int empty = 0;

		List<Integer> prefix = new ArrayList<>();

		while(empty < n && arr[empty] > y)
		{
			empty++;
			prefix.add(empty);
		}

		while(n - 1 > empty && arr[n-1] > y)
			n--;

		return dfs(arr, n, empty, 0, 0, empty, x, y, prefix);
	}

	public static int dfs(int[] arr, int n, int index, int total, int taken, int empty, int x, int y, List<Integer> prefix)
	{
		if(x <= total && total <= y)
			return prefix.get(taken-1);

		if(index == n || total > y)
			return -1;

		if(dp[taken][total] != -2)
			return dp[taken][total];

		int min1 = -1, min2 = -1;

		if(arr[index] <= y)
		{
			prefix.add(empty);
			min1 = dfs(arr, n, index + 1, total + arr[index], taken+1, empty, x, y, prefix);
			prefix.remove(prefix.size()-1);
		}


		prefix.add(empty+1);
		min2 = dfs(arr, n, index + 1, total, taken, empty+1, x, y, prefix);
		prefix.remove(prefix.size()-1);

		int res = -1;

		if(min1 == -1 && min2 == -1)
			res = -1;

		else if(min1 == -1)
			res = min2;

		else if(min2 == -1)
			res = min1;

		else
			res = Math.min(min1, min2);

		return dp[taken][total] = res;
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

/*
9
3 4 5
1 2 3
3 3 4
1 2 3
2 20 30
40 10
7 9 10
5 7 6 9 2 3 1
8 15 17
21 22 9 7 6 4 6 2
3 10 15
3 6 11
10 1 50
23 57 34 19 12 4 8 16 8 1
7 7 10
20 5 5 5 5 20 20
8 100 100
41 23 37 29 11 31 13 15
*/