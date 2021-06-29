import java.io.*;
import java.util.*;

class MinReverseCoins{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int count0 = 0, count1 = 0;

		for(int i = 0; i < n; i++)
		{
			if(i % 2 == 0)
			{
				if(arr[i] == 0)
					count0++;
				if(arr[i] == 1)
					count1++;
			}
			else
			{
				if(arr[i] == 1)
					count0++;
				if(arr[i] == 0)
					count1++;
			}
		}

		return Math.min(count0, count1);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}