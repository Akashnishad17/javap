import java.io.*;
import java.util.*;

class XxOoRr{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		int[][] arr = new int[n][31];

		st = br.readLine().split(" ");
		int x;

		for(int i = 0; i < n; i++)
		{
			x = Integer.parseInt(st[i]);

			int j = 0;

			while(j < 31)
			{
				arr[i][j++] = x % 2;
				x /= 2;
			}
		}

		int min = 0, count;

		for(int j = 0; j < 31; j++)
		{
			count = 0;

			for(int i = 0; i < n; i++)
				count += arr[i][j];

			min += count/k + (count % k == 0 ? 0 : 1);
		}


		return min;
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