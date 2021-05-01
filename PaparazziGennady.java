import java.io.*;
import java.util.*;

class PaparazziGennady{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long[] arr = new long[n];

		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st[i]);

		int max = 1;

		for(int i = 0; i < n-1; i++)
		{
			int mid = i + 1;
			long h = arr[i + 1];

			for(int j = i + 2; j < n; j++)
			{
				if((mid - i) * arr[j] + (j - mid) * arr[i] >= h * (j - i))
				{
					max = Math.max(max, j - i);
					mid = j;
					h = arr[j];
				}
			}
		}

		return max;
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