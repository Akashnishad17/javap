import java.io.*;
import java.util.*;

class ModularEquation{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int count = 0, a;
		int[] arr = new int[n+1];

		Arrays.fill(arr, 1);

		for(int i = 2; i <= n; i++)
		{
			a = m % i;

			count += arr[a];

			for(int j = a; j <= n; j += i)
				arr[j]++;
		}

		return count;
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