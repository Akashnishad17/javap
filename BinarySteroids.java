import java.io.*;
import java.util.*;

class BinarySteroids{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String s = br.readLine();

		int ones = 0, zeroes = 0;

		for(int i = 0; i < n; i++)
		{
			if(s.charAt(i) == '0')
				zeroes++;
			else
				ones++;
		}

		List<Integer> fact = new ArrayList<>();

		for(int i = 1; i <= (int)Math.sqrt(n); i++)
		{
			if(n % i == 0)
			{
				if(n % i != i)
					fact.add(n/i);

				fact.add(i);
			}
		}

		int min = n, req, convert;

		for(int d : fact)
		{
			int[] freq = new int[d];

			for(int i = 0; i < d; i++)
			{
				for(int j = i; j < n; j += d)
				{
					if(s.charAt(j) == '1')
						freq[i]++;
				}
			}

			req = n/d;

			for(int i = 0; i < d; i++)
			{
				convert = ones + req - 2*freq[i];
				min = Math.min(convert, min);
			}
		}

		return min;
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