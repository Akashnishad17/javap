import java.io.*;
import java.util.*;

class RangeSum{

	public static int[][] seg;

	public static void build(int[] arr, int index, int low, int high)
	{
		if(low == high)
		{
			seg[index][0] = arr[low];
			return;
		}

		int mid = (low + high)/2;
		build(arr, 2*index+1, low, mid);
		build(arr, 2*index+2, mid+1, high);

		seg[index][0] = seg[2*index+1][0] + seg[2*index+2][0];
	}

	public static int query(int index, int low, int high, int l, int r)
	{
		if(seg[index][1] > 0)
		{
			seg[index][0] += (high-low+1)*seg[index][1];
			
			if(low < high)
			{
				seg[2*index+1][1] += seg[index][1];
				seg[2*index+2][1] += seg[index][1];
			}

			seg[index][1] = 0;
		}
		if(r < low || l > high || low > high)
			return 0;

		if(low >= l && high <= r)
			return seg[index][0];

		int mid = (low + high)/2;
		int left = query(2*index+1, low, mid, l, r);
		int right = query(2*index+2, mid+1, high, l, r);

		return left + right;
	}

	public static void update(int index, int low, int high, int l, int r, int v)
	{
		if(seg[index][1] > 0)
		{
			seg[index][0] += (high-low+1)*seg[index][1];

			if(low < high)
			{
				seg[2*index+1][1] += seg[index][1];
				seg[2*index+2][1] += seg[index][1];
			}

			seg[index][1] = 0;
		}
		if(r < low || l > high || low > high)
			return;

		if(low >= l && high <= r)
		{
			seg[index][0] += (high-low+1)*v;

			if(low < high)
			{
				seg[2*index+1][1] += v;
				seg[2*index+2][1] += v;
			}
			return;
		} 

		int mid = (low + high)/2;
		update(2*index+1, low, mid, l, r, v);
		update(2*index+2, mid+1, high, l, r, v);

		seg[index][0] = seg[2*index+1][0] + seg[2*index+2][0];
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		seg = new int[3*n-1][2];
		build(arr, 0, 0, n-1);
		
		int q = sc.nextInt();
		char c;
		int x, y, v;
		
		while(q-- > 0)
		{
			c = sc.next().charAt(0);
			x = sc.nextInt();
			y = sc.nextInt();
			
			if(c == 'Q')
				System.out.println(query(0, 0, n-1, x-1, y-1));
			else
			{
				v = sc.nextInt();
				update(0, 0, n-1, x-1, y-1, v);
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input1.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = sc.nextInt();
		while(t-- > 0)
		{
			solve(sc);
		}
	}
}