import java.io.*;
import java.util.*;

class ChefAndTrump{

	public static int m = 1000000007;
	
	public static long power(long x, long n)
	{
		long res = 1;
		while(n > 0)
		{
			if((n&1) > 0)
				res = (res*x) % m;
			n /= 2;
			x = (x*x) % m;
		}
		return res;
	}

	public static long helper(long a, long b)
	{
		return (a % m * (power(b, m - 2) % m)) % m;
	}

	public static long solution(long n, long r)
	{
		long res = 1;
		long k = r > n-r ? r : n-r;
		for(int i = 0; i < k; i++)
		{
			res = (res % m * (n-i) % m) % m;
			res = helper(res, i + 1);
		}
		return res % m; 
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			long[] arr = new long[n];
			long max = 0, max_count = 0;
			for(int i = 0; i < n; i++)
			{
				arr[i] = sc.nextLong();
				if(arr[i] > max)
				{
					max = arr[i];
					max_count = 1;
				}
				else if(arr[i] == max)
					max_count++;
			}
			if(n == 1)
			{
				System.out.println(2);
				continue;
			}
			long res = power(2, n) % m - (max_count % 2 != 0 ? 0 : ((power(2, n - max_count) % m)*solution(max_count, max_count/2) % m) % m);
			if(res < 0)
				res = (res + m) % m;
			System.out.println(res%m);
		}
	}
}