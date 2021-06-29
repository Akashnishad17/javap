import java.io.*;
import java.util.*;

class Training{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int p = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);

		int sum = 0;

		for(int i = 0; i < p; i++)
			sum += arr[i];

		int min = arr[p-1]*p - sum;

		for(int i = p; i < n; i++)
		{
			sum += arr[i] - arr[i-p];
			min = Math.min(min, arr[i]*p - sum);
		}

		return min;
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