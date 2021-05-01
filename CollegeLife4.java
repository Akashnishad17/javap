import java.io.*;
import java.util.*;

class CollegeLife4{
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		long e = Long.parseLong(st[1]);
		long h = Long.parseLong(st[2]);
		long a = Long.parseLong(st[3]);
		long b = Long.parseLong(st[4]);
		long c = Long.parseLong(st[5]);

		long res = -1, min, max;
		boolean found = false;

		for(int x = 0; x <= n; x++)
		{	
			if(n <= 100)
			{
				for(int y = 0; y <= n - x; y++)
				{
					if(0 <= n + x - y  && n + x - y <= e && 0 <= n - x + 2*y && n - x + 2*y <= h)
					{
						long val = (a - c) * x + (b - c) * y + c * n;
						if(found)
							res = Math.min(res, val);
						else
						{
							res = val;
							found = true;
						}
					}
				}
			}
			else
			{
				min = 0;
				max = n - x;

				min = Math.max(min, n + x - e);
				max = Math.min(max, (h - n + x)/2);

				if(min <= max)
				{
					long val = (a - c) * x + c * n;

					if(b > c)
						val += (b - c) * min;
					else
						val += (b - c) * max;

					if(found)
						res = Math.min(res, val);
					else
					{
						res = val;
						found = true;
					}
				}
			}
		}

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