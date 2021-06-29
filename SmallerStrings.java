import java.io.*;
import java.util.*;

class SmallerStrings{

	public static int mod = 1000000007;

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		String s = br.readLine();

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = s.charAt(i) - 'a' + 1;

		boolean palidrone = true;
		int min;

		for(int i = 0; i <= n/2; i++)
		{
			if(arr[i] != arr[n - i - 1])
			{
				palidrone = false;
				min = Math.min(Math.min(arr[i], arr[n - i - 1]), k);
				arr[i] = min;
				arr[n - i - 1] = min;
			}
			else if(arr[i] > k)
			{
				palidrone = false;
				arr[i] = k;
				arr[i-1] = k;
			}
		}

		long[] pow = new long[n];

		pow[0] = 1;

		for(int i = 1; i < n; i++)
			pow[i] = (pow[i-1] * k) % mod;

		long res = 1;

		int size = n/2 + (n % 2 == 1 ? 1 : 0);

		for(int i = 0; i < size; i++)
			res = (res + ((arr[i] - 1) * (pow[size - i - 1]))) % mod;

		if(palidrone)
			res--;

		return res;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= t; i++)
			sb.append("Case #"+i+": "+solve(br)+"\n");

		System.out.print(sb.toString());
	}
}