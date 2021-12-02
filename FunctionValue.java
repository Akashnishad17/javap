import java.io.*;
import java.util.*;

class FunctionValue{

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int mod = 1000000007;
		int num;
		long odd;

		int[][] arr = new int[n][20];

		for(int i = 0; i < n; i++)
		{
			num = Integer.parseInt(st[i]);

			for(int j = 0; j < 20; j++)
			{
				num /= 2;
				arr[i][j] = num % 2;
			}
		}

		long sum = 0;

		for(int i = 0; i < 20; i++)
		{
			odd = 0;

			for(int j = 0; j < n; j++)
			{
				if(arr[j][i] == 1)
					odd++;
			}

			sum = (sum + ((1 << (i + 1)) * ((odd * (odd - 1)) / 2)) % mod) % mod;
		}

		return sum;
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