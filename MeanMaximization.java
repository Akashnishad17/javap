import java.io.*;
import java.util.*;

class MeanMaximization{
	public static double solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		double[] arr = new double[n+1];

		String[] st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i+1] = Double.parseDouble(st[i]);

		Arrays.sort(arr);

		double max = 0;

		for(int i = 1; i <= n; i++)
			arr[i] += arr[i-1];

		for(int i = 1; i < n; i++)
		{
			double sum = arr[i]/i + (arr[n] - arr[i])/(n - i);
			max = Math.max(sum, max);
		}

		return max;
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