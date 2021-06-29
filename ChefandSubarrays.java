import java.io.*;
import java.util.*;

class ChefandSubarrays{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");

		if(n == k)
			return 0;

		long[] arr = new long[n+1];

		HashMap<Long, Integer> map = new HashMap<>();

		long sum;

		for(int i = 1; i <= n; i++)
		{
			arr[i] = Long.parseLong(st[i-1]);
			arr[i] += arr[i-1];

			if(i - k >= 0)
			{
				sum = arr[i] - arr[i-k];
				map.put(sum, map.getOrDefault(sum, 0) + 1); 
			}
		}

		int max = -1;

		for(int x : map.values())
			max = Math.max(max, x);	

		return n - k + 1 - max;
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