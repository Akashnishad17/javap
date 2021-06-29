import java.io.*;
import java.util.*;

class BenchPress{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int w = Integer.parseInt(st[1]);
		int wr = Integer.parseInt(st[2]);

		st = br.readLine().split(" ");

		w -= wr;

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		if(w <= 0)
			return "Yes";

		Arrays.sort(arr);

		int i = n-1;

		int sum = 0;

		while(i > 0)
		{
			if(arr[i] == arr[i-1])
			{
				sum += 2 * arr[i];
				i -= 2;
			}
			else
				i--;

			if(sum >= w)
				return "Yes";
		}

		return "No";
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