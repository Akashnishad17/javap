import java.io.*;
import java.util.*;

class InteractiveTree{
	public static void solve(Scanner sc) throws Exception
	{
		int n = sc.nextInt();

		int edge = n - 1;

		while(edge-- > 0)
		{
			sc.nextInt();
			sc.nextInt();
		}

		int left = 1, right = n, mid;

		int count = 0;

		while(left < right)
		{
			count++;

			if(count > 21)
				new Exception();

			mid = left + (right - left)/2;

			StringBuilder sb = new StringBuilder();

			sb.append("? " + (mid - left + 1) + " ");

			for(int i = left; i <= mid; i++)
				sb.append(i + " ");

			System.out.println(sb.toString());

			int res = sc.nextInt();;

			if(res == 1)
				right = mid;
			else
				left = mid + 1;
		}

		System.out.println("! " + left);
	}
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0)
			solve(sc);
	}
}