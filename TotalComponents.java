import java.io.*;
import java.util.*;

class TotalComponents{

	public static int[] arr;
	static{
		int max = 10000000;
		arr = new int[max+1];
		boolean[] prime = new boolean[max+1];

		Arrays.fill(prime, true);

		for(int i = 2; i <= 10000; i++)
		{
			if(prime[i])
			{
				for(int j = i*i; j <= max; j += i)
					prime[j] = false;
			}
		}

		arr[2] = 1;
		arr[3] = 2;
		arr[4] = 2;

		for(int i = 5; i <= max; i++)
		{
			arr[i] = arr[i-1];
			if(prime[i])
				arr[i] += 1;

			if(i % 2 == 0 && prime[i/2])
				arr[i] -= 1;
		}
	}

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		return arr[n];
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