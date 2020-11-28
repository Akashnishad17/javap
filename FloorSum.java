import java.io.*;
import java.util.*;

class FloorSum{

	public static int solve(int[] arr, int n)
	{
		int MAX = 100001;
		long[] prefix = new long[MAX+1];
		long[] freq = new long[MAX+1];

		long sum = 0;
		for(int x : arr)
		{
			if(x != 1)
				sum += x;

			freq[x]++;
			prefix[x]++;
		}

		long res = 0;

		for(int i = 1; i <= MAX; i++)
			prefix[i] += prefix[i-1];

		for(int i = 2; i <= MAX; i++)
		{
			if(freq[i] > 0)
			{
				long round = 1;
				int j = 2*i;

				while(j <= MAX)
				{
					res = (res + freq[i] * (prefix[j-1] - prefix[j-i-1]) * round) % 1000003;
					
					round++;
					j += i;
				}

				res = (res + freq[i] * (prefix[MAX] - prefix[j-i-1]) * round) % 1000003;
				
			}
		}

		res = (res + freq[1] * freq[1] + freq[1] * sum) % 1000003;

		return (int)(res % 1000003);
	} 

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			String[] st = br.readLine().split(" ");

			int[] arr = new int[n];

			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st[i]);
			System.out.println(solve(arr, n));
		}
	}
}