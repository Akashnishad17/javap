import java.io.*;
import java.util.*;

class TCountbackup{

	public static long nCr(long n, int r)
	{
		if(r == 2)
			return (n * (n - 1))/2;

		return (n * (n - 1) * (n - 2))/6;
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

		if(arr[l] >= x)
			return -1;

		if(arr[r] >= x)
			return l;

		return r;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");		
		
		TreeMap<Integer,Integer> map = new TreeMap<>();
		int x, i;
		
		for(i = 0; i < n; i++)
		{
			x = Integer.parseInt(st[i]);
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		n = map.size();

		int[] arr = new int[n];
		long[] count = new long[n];
		long[] prefix = new long[n];
		i = 0;

		for(Map.Entry<Integer,Integer> e : map.entrySet())
		{
			arr[i] = e.getKey();
			count[i] = e.getValue();
			prefix[i] = count[i];

			if(i > 0)
				prefix[i] += prefix[i-1];

			i++;
		}

		long res = 0;
		long sum;

		for(i = 0; i < n; i++)
		{
			if(count[i] >= 3)
			{
				sum = 0;
				for(int j = 0; j < n; j++)
				{
					if(i == j)
						continue;

					if(3*arr[i] <= arr[j])
						break;

					sum += count[j];
				}

				res += sum * nCr(count[i], 3);
			}
		}

		int index;

		for(i = 0; i < n; i++)
		{
			if(count[i] >= 2)
			{
				sum = 0;

				for(int j = 0; j < n-1; j++)
				{
					if(i == j)
						continue;

					index = upperBound(arr, j+1, n-1, 2*arr[i] + arr[j]);
					
					if(index != -1)
						sum += count[j] * (prefix[index] - prefix[j] - (j < i && i <= index ? count[i] : 0));
				}

				res += sum * nCr(count[i], 2);

			}
		}

		return res;
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}