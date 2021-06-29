import java.io.*;
import java.util.*;

class LockedSafe{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long[] arr = new long[n];

		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st[i]);

		int i = 0;
		int j = 0;

		long res = ((long)n * (n - 1))/2;
		long diff;

		while(j < n)
		{
			if(arr[i] == arr[j])
				j++;
			else
			{
				diff = j - i;
				
				if(arr[i] != 0)
					res -= (diff * (diff - 1))/2;
				i = j;
			}
		}

		diff = j - i;

		if(arr[i] != 0)
			res -= (diff * (diff - 1))/2;

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