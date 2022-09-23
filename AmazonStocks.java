import java.io.*;
import java.util.*;

class AmazonStocks{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		List<Integer> stockPrice = new ArrayList<>();

		for(String s : st)
			stockPrice.add(Integer.parseInt(s));

		int n = stockPrice.size();

		double[] arr = new double[n];

		for(int i = 0; i < n; i++)
		{
			arr[i] = (double)stockPrice.get(i);
			if(i > 0)
				arr[i] += arr[i-1];
		}

		int index = -1;
		double min = Double.MAX_VALUE;

		for(int i = 0; i < n - 1; i++)
		{
			double left = arr[i] / (i + 1);
			double right = (arr[n - 1] - arr[i]) / (n - i - 1);

			double abs = Math.abs(left - right);
			
			if(abs < min)
			{
				index = i + 1;
				min = abs;
			}
		}

		return index;
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}