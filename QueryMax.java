import java.io.*;
import java.util.*;

class QueryMax{

	public static void buildSegment(int[] arr, int[] seg, int index, int low, int high)
	{
		if(low == high)
		{
			seg[index] = arr[low];
			return;
		}
		int mid = (low + high)/2;
		buildSegment(arr, seg, 2*index+1, low, mid);
		buildSegment(arr, seg, 2*index+2, mid+1, high);
		seg[index] = Math.max(seg[2*index+1], seg[2*index+2]);
	} 

	public static int query(int[] seg, int index, int low, int high, int l, int r)
	{
		if(low > r || high < l)
			return Integer.MIN_VALUE;
		if(low >= l && high <= r)
			return seg[index];
		int mid = (low+high)/2;
		int left = query(seg, 2*index+1, low, mid, l, r);
		int right = query(seg, 2*index+2, mid+1, high, l, r);
		return Math.max(left, right);
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int[] seg = new int[3*n-1];
		buildSegment(arr, seg, 0, 0, n-1);
		int q = sc.nextInt();
		int l, r;
		while(q-- > 0)
		{
			l = sc.nextInt();
			r = sc.nextInt();
			System.out.println(query(seg, 0, 0, n-1, l, r));
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
		{
			solve(sc);
		}
	}
}