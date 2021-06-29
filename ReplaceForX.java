import java.io.*;
import java.util.*;

class ReplaceForX{

	public static int lowerBound(int[] arr, int l, int r, int x)
	{
		int mid;

		while(r - l > 1)
		{
			mid = l + (r - l)/2;

			if(arr[mid] <= x)
				l = mid + 1;
			else
				r = mid;
		}

		if(arr[l] > x)
			return l;

		return r + (arr[r] == x ? 1 : 0);
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

		if(arr[r] < x)
			return r;

		return l - (arr[l] == x ? 1 : 0);
	}

	public static int solve(Scanner sc)
	{
		int n = sc.nextInt();
		int x = sc.nextInt();
		int p = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);

		if(p == k)
		{
			if(arr[p-1] == x)
				return 0;

			if(arr[p-1]  < x)
				return upperBound(arr, p-1, n-1, x) - (p - 1) + 1;

			return (p - 1) - lowerBound(arr, 0, p-1, x) + 1;
		}

		else if(p < k)
		{
			if(arr[p-1] < x)
				return -1;

			return (p - 1) - lowerBound(arr, 0, p-1, x) + 1;
		}

		else
		{
			if(arr[p-1] > x)
				return -1;

			return upperBound(arr, p-1, n-1, x) - (p - 1) + 1;
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
			System.out.println(solve(sc));
	}
}