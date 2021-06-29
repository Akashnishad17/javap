import java.io.*;
import java.util.*;

class TrapezoidCounting{

	public static long nCr(long n, int r)
	{
		if(r == 2)
			return (n * (n - 1))/2;

		return (n * (n - 1) * (n - 2))/6;
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

		long[] arr = new long[n];
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

		int j, k;

		for(i = 0; i < n; i++)
		{
			if(count[i] >= 2)
			{
				sum = 0;
				j = 0;
				k = 0;

				while(j < n && k < n)
				{
					if(j == i)
					{
						j++;
						continue;
					}

					while(k+1 < n && 2*arr[i] + arr[j] > arr[k+1])
						k++;

					sum += count[j] * (prefix[k] - prefix[j] - (j < i && i <= k ? count[i] : 0));

					j++;
				}

				res += sum * nCr(count[i], 2);

			}
		}

		return res;
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