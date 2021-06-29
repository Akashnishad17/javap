import java.io.*;
import java.util.*;

class BlackJack3{

	public static class Prefix{

		int taken;
		int empty;
		int level;

		Prefix left;
		Prefix right;
		Prefix parent;
		Prefix special;
		String unicode;

		public Prefix(){
			unicode = "";
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
		dp[0][0].special = dp[0][0];

		int best = -1;

		for(int i = 1; i <= n; i++)
		{
			for(int j = 0; j <= y; j++)
			{
				if(j == 0)
				{
					dp[i][j] = new Prefix();
					dp[i][j].empty = i;

					dp[i-1][j].right = dp[i][j];
					dp[i][j].parent = dp[i-1][j];
					dp[i][j].special = dp[0][0];

					dp[i][j].level = dp[i-1][j].level + 1;
					dp[i][j].unicode = dp[i-1][j].unicode + '0';
				}

				else
				{

					if(j < arr[i-1])
					{
						if(dp[i-1][j] != null)
						{
							dp[i][j] = new Prefix();
							dp[i][j].empty = dp[i-1][j].empty + 1;
							dp[i][j].taken = dp[i-1][j].taken;

							dp[i-1][j].right = dp[i][j];
							dp[i][j].parent = dp[i-1][j];
							dp[i][j].special = dp[i-1][j].special;

							dp[i][j].level = dp[i-1][j].level + 1;
							dp[i][j].unicode = dp[i-1][j].unicode + '0';
						}
					}
					else
					{

						if(dp[i-1][j] != null && dp[i-1][j-arr[i-1]] != null)
						{
							int c1 = dp[i-1][j].special.empty;
							int c2 = dp[i-1][j-arr[i-1]] == dp[i-1][j-arr[i-1]].special ? 0 : -1;

							if(c2 == -1)
							{
								//System.out.println(dp[i-1][j-arr[i-1]].special.right + " " + dp[i-1][j-arr[i-1]].special.left);

								if(dp[i-1][j-arr[i-1]].special.left != null && dp[i-1][j-arr[i-1]].special.right != null)
									c2 = dp[i-1][j-arr[i-1]].unicode.charAt(dp[i-1][j-arr[i-1]].special.level) == '0' ? dp[i-1][j-arr[i-1]].special.right.empty : dp[i-1][j-arr[i-1]].special.left.empty;
								if(dp[i-1][j-arr[i-1]].special.left != null)
									c2 = dp[i-1][j-arr[i-1]].special.left.empty;
								else
									c2 = dp[i-1][j-arr[i-1]].special.right.empty;
							}

							/*Prefix temp = dp[i-1][j-arr[i-1]];

							if(c2 == -1)
							{

								while(temp.parent != dp[i-1][j-arr[i-1]].special)
									temp = temp.parent;

								c2 = temp.empty;
							}*/

							if(c1 <= c2)
							{
								dp[i][j] = new Prefix();
								dp[i][j].empty = dp[i-1][j].empty + 1;
								dp[i][j].taken = dp[i-1][j].taken;

								dp[i-1][j].right = dp[i][j];
								dp[i][j].parent = dp[i-1][j];
								dp[i][j].special = dp[i-1][j].special;

								dp[i][j].level = dp[i-1][j].level + 1;
								dp[i][j].unicode = dp[i-1][j].unicode + '0';
							}
							else
							{
								dp[i][j] = new Prefix();
								dp[i][j].empty = dp[i-1][j-arr[i-1]].empty;
								dp[i][j].taken = dp[i-1][j-arr[i-1]].taken + 1;

								dp[i][j].level = dp[i-1][j-arr[i-1]].level + 1;
								dp[i][j].unicode = dp[i-1][j-arr[i-1]].unicode + '1';

								dp[i-1][j-arr[i-1]].left = dp[i][j];
								dp[i][j].parent = dp[i-1][j-arr[i-1]];

								/*if(c2 == 0)
									dp[i][j].special = dp[i][j]; 
								else
									dp[i][j].special = temp;*/

								if(dp[i-1][j-arr[i-1]].special.left != null && dp[i-1][j-arr[i-1]].special.right != null)
									dp[i][j].special = dp[i-1][j-arr[i-1]].unicode.charAt(dp[i-1][j-arr[i-1]].special.level) == '0' ? dp[i-1][j-arr[i-1]].special.right : dp[i-1][j-arr[i-1]].special.left;
								else if(dp[i-1][j-arr[i-1]].special.left != null)
									dp[i][j].special = dp[i-1][j-arr[i-1]].special.left;
								else
									dp[i][j].special = dp[i-1][j-arr[i-1]].special.right;

								

							}
						}

						else if(dp[i-1][j] != null)
						{
							dp[i][j] = new Prefix();
							dp[i][j].empty = dp[i-1][j].empty + 1;
							dp[i][j].taken = dp[i-1][j].taken;

							dp[i-1][j].right = dp[i][j];
							dp[i][j].parent = dp[i-1][j];
							dp[i][j].special = dp[i-1][j].special;

							dp[i][j].level = dp[i-1][j].level + 1;
							dp[i][j].unicode = dp[i-1][j].unicode + '0';
						}

						else if(dp[i-1][j-arr[i-1]] != null)
						{
							dp[i][j] = new Prefix();
							dp[i][j].empty = dp[i-1][j-arr[i-1]].empty;
							dp[i][j].taken = dp[i-1][j-arr[i-1]].taken + 1;

							dp[i-1][j-arr[i-1]].left = dp[i][j];
							dp[i][j].parent = dp[i-1][j-arr[i-1]];

							dp[i][j].level = dp[i-1][j-arr[i-1]].level + 1;
							dp[i][j].unicode = dp[i-1][j-arr[i-1]].unicode + '1';


							/*int c2 = dp[i-1][j-arr[i-1]] == dp[i-1][j-arr[i-1]].special ? 0 : -1;

							Prefix temp = dp[i-1][j-arr[i-1]];

							if(c2 == -1)
							{
								while(temp.parent != dp[i-1][j-arr[i-1]].special)
									temp = temp.parent;

								c2 = temp.empty;
							}

							if(c2 == 0)
								dp[i][j].special = dp[i][j]; 
							else
								dp[i][j].special = temp;*/

							
							//dp[i][j].special = dp[i-1][j-arr[i-1]].unicode.charAt(dp[i-1][j-arr[i-1]].special.level) == '0' ? dp[i-1][j-arr[i-1]].special.right : dp[i-1][j-arr[i-1]].special.left;
						
							if(dp[i-1][j-arr[i-1]].special.left != null && dp[i-1][j-arr[i-1]].special.right != null)
								dp[i][j].special = dp[i-1][j-arr[i-1]].unicode.charAt(dp[i-1][j-arr[i-1]].special.level) == '0' ? dp[i-1][j-arr[i-1]].special.right : dp[i-1][j-arr[i-1]].special.left;
							else if(dp[i-1][j-arr[i-1]].special.left != null)
								dp[i][j].special = dp[i-1][j-arr[i-1]].special.left;
							else
								dp[i][j].special = dp[i-1][j-arr[i-1]].special.right;
						}

					}
				}

				if(x <= j && j <= y && dp[i][j] != null)
				{
					int val = dp[i][j].special.empty;
						
					if(best == -1)
						best = val;
					else
						val = Math.min(val, best);
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