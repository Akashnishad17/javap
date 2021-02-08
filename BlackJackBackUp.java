import java.io.*;
import java.util.*;

class BlackJackBackUp{

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);
		int y = Integer.parseInt(st[2]);

		int[] arr = new int[n+1];
		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i+1] = Integer.parseInt(st[i]);

		int[][] dp = new int[n+1][y+1];
		dp[0][0] = 1;

		for(int i = 1; i <= n; i++)
		{
			for(int s = 0; s <= y; s++)
			{
				if(s == 0)
					dp[i][s] = 1;
				else
				{
					if(s < arr[i])
						dp[i][s] = dp[i-1][s];
					else
						dp[i][s] = dp[i-1][s] + dp[i-1][s - arr[i]];
				}
				System.out.print(dp[i][s]+" ");
			}

			System.out.println();
		}

		int count = 0;

		//return dfs(arr, 0, 0, 0, 0, x, y, new ArrayList<>());
		return count;
	}

	/*public static int dfs(int[] arr, int index, int total, int taken, int empty, int x, int y, List<Integer> prefix)
	{
		if(x <= total && total <= y)
			return prefix.get(taken-1);

		if(index == arr.length || total > y)
			return -1;

		if(dp[index][total] != -2)
			return dp[index][total];

		int min1 = -1, min2 = -1;

		prefix.add(empty);
		min1 = dfs(arr, index + 1, total + arr[index], taken+1, empty, x, y, prefix);
		prefix.remove(prefix.size()-1);

		prefix.add(empty+1);
		min2 = dfs(arr, index + 1, total, taken, empty+1, x, y, prefix);
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

		return dp[index][total] = res;
	}*/

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
4
3 4 5
1 2 3
3 3 4
1 2 3
2 20 30
40 10
8 10 18
5 7 6 9 2 3 4 1
*/