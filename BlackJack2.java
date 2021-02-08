import java.io.*;
import java.util.*;

class BlackJack2{

	public static class Prefix{

		int taken;
		List<Integer> prefix;

		public Prefix()
		{
			prefix = new ArrayList<>();
			taken = 0;
		}

	}

	public static Prefix[][] dp;

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);
		int y = Integer.parseInt(st[2]);

		int[] arr = new int[n];
		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		dp = new Prefix[n+1][y+1];

		dp[0][0] = new Prefix();
		dp[0][0].prefix.add(0);

		Prefix a, b;

		int best = -1;

		for(int i = 1; i <= n; i++)
		{
			for(int j = 0; j <= y; j++)
			{
				if(j == 0)
				{
					dp[i][j] = new Prefix();
					dp[i][j].prefix = new ArrayList<>(dp[i-1][j].prefix);
					dp[i][j].prefix.add(i);
				}

				else
				{

					if(j < arr[i-1])
					{
						if(dp[i-1][j] != null)
						{
							dp[i][j] = new Prefix();
							dp[i][j].prefix = new ArrayList<>(dp[i-1][j].prefix);
							dp[i][j].prefix.add(dp[i-1][j].prefix.get(dp[i-1][j].prefix.size()-1)+1);
							dp[i][j].taken = dp[i-1][j].taken;
						}
					}
					else
					{
						a = dp[i-1][j];
						b = dp[i-1][j-arr[i-1]];

						if(dp[i-1][j] != null && dp[i-1][j-arr[i-1]] != null)
						{
							if((int)a.prefix.get(a.taken) <= (int)b.prefix.get(b.taken+1))
							{
								dp[i][j] = new Prefix();
								dp[i][j].prefix = new ArrayList<>(dp[i-1][j].prefix);
								dp[i][j].prefix.add(dp[i-1][j].prefix.get(dp[i-1][j].prefix.size()-1) + 1);
								dp[i][j].taken = dp[i-1][j].taken;	
							}
							else
							{
								dp[i][j] = new Prefix();
								dp[i][j].prefix = new ArrayList<>(dp[i-1][j-arr[i-1]].prefix);
								dp[i][j].prefix.add(dp[i-1][j].prefix.get(dp[i-1][j].prefix.size()-1));
								dp[i][j].taken = dp[i-1][j-arr[i-1]].taken + 1;
							}
						}

						else if(dp[i-1][j] != null)
						{
							dp[i][j] = new Prefix();
							dp[i][j].prefix = new ArrayList<>(dp[i-1][j].prefix);
							dp[i][j].prefix.add(dp[i-1][j].prefix.get(dp[i-1][j].prefix.size()-1) + 1);
							dp[i][j].taken = dp[i-1][j].taken;
						}

						else if(dp[i-1][j-arr[i-1]] != null)
						{
							dp[i][j] = new Prefix();
							dp[i][j].prefix = new ArrayList<>(dp[i-1][j-arr[i-1]].prefix);
							dp[i][j].prefix.add(dp[i-1][j-arr[i-1]].prefix.get(dp[i-1][j-arr[i-1]].prefix.size()-1));
							dp[i][j].taken = dp[i-1][j-arr[i-1]].taken + 1;
						}
					}
				}

				if(x <= j && j <= y && dp[i][j] != null)
				{
					int val = dp[i][j].prefix.get(dp[i][j].taken);

					if(best == -1)
						best = val;
					else
						best = Math.min(best, val);
				}				
			}
		}

		return best;
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