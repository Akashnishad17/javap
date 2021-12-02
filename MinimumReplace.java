import java.io.*;
import java.util.*;

class MinimumReplace{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);

		int min = n;
		int temp;

		for(int i = 0; i < n; i++)
		{
			temp = upperBound(arr, i, n-1, arr[i] + n);
			min = Math.min(min, n - (temp - i + 1));
		}

		return min;
	}

	public static int upperBound(int[] arr, int l, int r, int x)
	{
		int mid;

		while(r - l > 1)
		{
			mid = l + (r - l)/2;

			if(arr[mid] >= x)
				r = mid - 1;
			else
				l = mid;
		}

		if(arr[r] >= x)
			return l;

		return r;
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