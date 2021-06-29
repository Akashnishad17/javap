import java.io.*;
import java.util.*;

class AbandonedCity{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		int tar = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(st[i]);

			if(i > 0)
				arr[i] += arr[i-1];
		}

		int min = n+1;

		for(int i = 0; i < n; i++)
		{
			int index = upperBound(arr, i, n, tar);

			if(index != -1)
				min = Math.min(min, index - i + 1);
		}

		if(min == n+1)
			return -1;
		return min;
	}

	public static int upperBound(int[] arr, int l, int r, int x)
	{
		int mid;
		int sum;

		int res = -1;

		int left = l > 0 ? arr[l-1] : 0;

		while(l < r)
		{
			mid = l + (r - l)/2;

			sum = arr[mid] - left;

			if(sum >= x)
			{
				r = mid;
				res = mid;
			}
			else
				l = mid + 1;
		}

		return res;
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