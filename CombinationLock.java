import java.io.*;
import java.util.*;

class CombinationLock{
	
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int w = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int[] arr = new int[w+1];

		for(int i = 1; i <= w; i++)
			arr[i] = Integer.parseInt(st[i-1]);

		Arrays.sort(arr);

		long[] prefix = new long[w+1];
		long[] suffix = new long[w+2];

		for(int i = 1; i <= w; i++)
			prefix[i] = arr[i] - 1 + prefix[i-1];

		for(int i = w; i >= 1; i--)
			suffix[i] = n - arr[i] + suffix[i+1];

		long min = Long.MAX_VALUE, val;
		int leftIndex, rightIndex;
		
		for(int i = 1; i <= w; i++)
		{
			leftIndex = lowerBound(arr, 1, i, arr[i], n);
			rightIndex = upperBound(arr, i, w, arr[i], n);

			val = helper(prefix, suffix, arr, n, w, i, leftIndex, rightIndex);
			min = Math.min(min, val);
		}

		return min;
	}

	public static long helper(long[] prefix, long[] suffix, int[] arr, int n, int w, int index, int l, int r)
	{
		long res = 0;
		
		res += suffix[l] - suffix[index] - ((long)(index - l))*(n - arr[index]);
		res += prefix[r] - prefix[index] - ((long)(r - index))*(arr[index] - 1);

		if(l != 1)
			res += prefix[l-1] + ((long)(l - 1))*(n + 1 - arr[index]);

		if(r != w)
			res += suffix[r+1] + ((long)(w - r))*(arr[index]);

		return res;	
	}

	public static int lowerBound(int[] arr, int l, int r, int x, int n)
	{
		int mid;
		int clock, anticlock;
		while(r - l > 1)
		{
			mid = l + (r - l)/2;
			clock = x - arr[mid];
			anticlock = n - x + arr[mid];

			if(clock > anticlock)
				l = mid + 1;
			else
				r = mid;
		}

		clock = x - arr[l];
		anticlock = n - x + arr[l];

		return clock > anticlock ? r : l;
	}

	public static int upperBound(int[] arr, int l, int r, int x, int n)
	{
		int mid;
		int clock, anticlock;
		while(r - l > 1)
		{
			mid = l + (r - l)/2;
			anticlock = arr[mid] - x;
			clock = n + x - arr[mid];

			if(anticlock > clock)
				r = mid - 1;
			else
				l = mid;
		}

		anticlock = arr[r] - x;
		clock = n + x - arr[r];

		return anticlock > clock ? l : r;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}