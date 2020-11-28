import java.io.*;
import java.util.*;
class MinStep{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			int max = arr[0];
			for(int x : arr)
				max = Math.max(max, x);
			int 
		}
	}
}