import java.io.*;
import java.util.*;

class LockedSafeBackUp{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long[] arr = new long[n];

		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st[i]);

		long res = ((long)n * (n + 1))/2;

		List<int[]> range = new ArrayList<>();


		for(int bit = 0; bit <= 60; bit++)
		{

			int i = 0;
			int j = 0;

			while(j < n)
			{
				boolean high1 = (arr[i] & (1l << bit)) > 0;
				boolean high2 = (arr[j] & (1l << bit)) > 0;

				if(high1 == high2)
					j++;
				else
				{
					
					if((arr[i] & (1l << bit)) > 0)
						range.add(new int[]{i, j - 1});
						
					i = j;
				}
			}

			if((arr[i] & (1l << bit)) > 0)
				range.add(new int[]{i, j - 1});
		}

		Collections.sort(range, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		int max = -1;

		List<int[]> rangeFinal = new ArrayList<>();

		for(int[] a : range)
		{
			if(max < a[1])
				rangeFinal.add(a);

			max = Math.max(a[1], max);
		}

		int prev = -1;
		long diff;

		for(int[] a : rangeFinal)
		{
			System.out.println(a[0]+" "+a[1]);
			diff = a[1] - a[0] + 1;
			res -= (diff * (diff + 1))/2;

			if(prev >= a[0])
			{
				diff = prev - a[0] + 1;
				res += (diff * diff + 1)/2; 
			}

			prev = a[1];
		}

		System.out.println();

		return res;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}