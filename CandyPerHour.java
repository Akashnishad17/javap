import java.io.*;
import java.util.*;

class CandyPerHour{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		long[] arr = new long[n];

		long sum = 0;

		for(int i = 0; i < n; i++)
		{
			arr[i] = Long.parseLong(br.readLine());
			sum += arr[i];
		}

		long hours = Long.parseLong(br.readLine());

		long l = 1, r = sum, mid, count;

		while(l < r)
		{
			mid = l + (r - l)/2;

			count = 0;

			for(int i = 0; i < n; i++)
			{
				count += arr[i]/mid;

				if(arr[i] % mid != 0)
					count++;
			}

			if(count <= hours)
				r = mid;
			else
				l = mid + 1;
		}

		return l;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}