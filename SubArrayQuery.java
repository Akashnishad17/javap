import java.io.*;
import java.util.*;

class SubArrayQuery{
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int len = (n * (n + 1))/2;

		int[] sum = new int[len+1];

		int k = 1;

		for(int i = 0; i < n; i++)
		{
			int cur = 0;
			for(int j = i; j < n; j++)
			{
				cur += arr[j];
				sum[k++] = cur;
			}
		}

		Arrays.sort(sum);

		for(int i = 1; i <= len; i++)
			sum[i] += sum[i-1];

		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			int l = Integer.parseInt(st[0]);
			int r = Integer.parseInt(st[1]);

			sb.append((sum[r] - sum[l - 1]) + "\n");
		}
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
			solve(br);

		System.out.print(sb.toString());
	}
}