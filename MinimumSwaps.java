import java.io.*;
import java.util.*;

class MinimumSwaps{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int count = 0;

		for(int i = 0; i < n; i++)
		{
			int real = n - i;

			if(arr[i] != real)
			{
				

				while(arr[i] != real)
				{
					count++;

					int val = arr[i];
					arr[i] = arr[n - val];
					arr[n - val] = val;
				}
			}
		}

		return count;
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