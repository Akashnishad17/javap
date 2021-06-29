import java.io.*;
import java.util.*;

class RangeMin{

	public static int[] seg;

	public static void build(int[] arr, int index, int low, int high)
	{
		if(low == high)
		{
			seg[index] = arr[low];
			return;
		}

		int mid = (low + high)/2;

		build(arr, 2*index+1, low, mid);
		build(arr, 2*index+2, mid+1, high);

		seg[index] = Math.min(seg[2*index+1], seg[2*index+2]); 
	}

	public static int query(int index, int low, int high, int l, int r)
	{
		if(r < low || high < l)
			return Integer.MAX_VALUE;

		if(l <= low && high <= r)
			return seg[index];

		int mid = (low + high)/2;

		int left = query(2*index+1, low, mid, l, r);
		int right = query(2*index+2, mid+1, high, l, r);

		return Math.min(left, right);
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		seg = new int[3*n-1];
		build(arr, 0, 0, n-1);

		int l, r;
		while(q-- > 0)
		{
			l = sc.nextInt();
			r = sc.nextInt();

			System.out.println(query(0, 0, n-1, l-1, r-1));
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));

		solve(sc);
	}
}