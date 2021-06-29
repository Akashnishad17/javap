import java.io.*;
import java.util.*;

class SearchingAlgorithm{

	public static void printIndex(int index)
	{
		if(index == -1)
			System.out.println("Element is not present in the array");
		else
			System.out.println("Element is present at index: "+index);
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]{-34, 40, 26, 0, -78, 49, 99, -5, -15, 47, -99, 75, 22, -30, 49, -30, 47, -1, 40, 5};
		int n = arr.length;

		//int index = LinearSearch.search(arr, n, 100);					//Line 42
		//int index = LinearSearch.recursiveSearch(arr, 0, n-1, 22);

		//Arrays.sort(arr);
		//int index = BinarySearch.search(arr, n, 22);					//Line 64
		//int index = BinarySearch.recursiveSearch(arr, 0, n-1, 77);

		//Arrays.sort(arr);
		//int index = JumpSearch.search(arr, n, 47);					//Line 96

		//Arrays.sort(arr);
		//int index = InterpolationSearch.search(arr, n, 77);			//Line 121

		//Arrays.sort(arr);
		//int index = ExponentialSearch.search(arr, n, -100);			//Line 147

		Arrays.sort(arr);
		int index = FibonacciSearch.search(arr, n, 5);					//Line 159

		printIndex(index);
	}
}

class LinearSearch{
	public static int search(int[] arr, int n, int x)
	{
		for(int i = 0; i < n; i++)
		{
			if(arr[i] == x)
				return i;
		}
		return -1;
	}
	public static int recursiveSearch(int[] arr, int l, int r, int x)
	{	
		if(l > r)
			return -1;
		if(arr[l] == x)
			return l;
		if(arr[r] == x)
			return r;
		return recursiveSearch(arr, l+1, r-1, x);
	}
}

class BinarySearch{
	public static int search(int[] arr, int n, int x)
	{
		int l = 0;
		int r = n-1;
		int mid;
		while(l <= r)
		{
			mid = l + (r-l)/2;
			if(arr[mid] == x)
				return mid;
			if(x < arr[mid])
				r = mid-1;
			else
				l = mid+1;
		}
		return -1;
	}
	public static int recursiveSearch(int[] arr, int l, int r, int x)
	{
		if(l > r)
			return -1;
		int mid = l + (r-l)/2;
		if(arr[mid] == x)
			return mid;
		if(arr[mid] > x)
			return recursiveSearch(arr, l, mid-1, x);
		else
			return recursiveSearch(arr, mid+1, r, x);
	}
}

class JumpSearch{
	public static int search(int[] arr, int n, int x)
	{
		int m = (int)Math.sqrt(n);
		int step = m;
		int prev = 0;
		while(arr[Math.min(step,n)-1] < x)
		{
			prev = step;
			step += m;
			if(prev >= n)
				return -1;
		}
		while(arr[prev] < x)
		{
			prev++;
			if(prev == Math.min(step,n))
				return -1;
		}
		if(arr[prev] == x)
			return prev;
		return -1;
	}
}

class InterpolationSearch{
	public static int search(int[] arr, int n, int x)
	{
		int l = 0;
		int h = n - 1;
		int pos;
		while(l <= h && x >= arr[l] && x <= arr[h])
		{
			if(l == h)
			{
				if(arr[l] == x)
					return l;
				return -1;
			}
			pos = l + ((x - arr[l])*(h-l))/(arr[h]-arr[l]);
			if(arr[pos] == x)
				return pos;
			if(arr[pos] > x)
				h = pos - 1;
			else
				l = pos + 1;
		}
		return -1;
	}
}

class ExponentialSearch{
	public static int search(int[] arr, int n, int x)
	{	
		if(arr[0] == x)
			return 0;
		int i = 1;
		while(i < n && x >= arr[i])
			i *= 2;
		return BinarySearch.recursiveSearch(arr, i/2, Math.min(i,n), x);
	}
}

class FibonacciSearch{
	public static int search(int[] arr, int n, int x)
	{
		int fib1 = 0;
		int fib2 = 1;
		int fibm = fib1 + fib2;
		while(fibm < n)
		{
			fib1 = fib2;
			fib2 = fibm;
			fibm = fib1 + fib2;
		}
		int offSet = -1, i;
		while(fibm > 1)
		{
			i = Math.min(offSet+fib1, n-1);
			if(arr[i] < x)
			{
				fibm = fib2;
				fib2 = fib1;
				fib1 = fibm - fib2;
				offSet = i;
			}
			else if(arr[i] > x)
			{
				fibm = fib1;
				fib2 -= fib1;
				fib1 = fibm - fib2;
			}
			else
				return i;
		}
		if(fib2 == 1 && arr[offSet+1] == x)
			return offSet+1;
		return -1;
	}
}

