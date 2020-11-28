import java.io.*;
import java.util.*;

class RecordBreaker{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int max = -1;
		int count = 0;

		for(int i = 0; i < n-1; i++)
		{
			if(arr[i] > max && arr[i] > arr[i+1])
				count++;

			max = Math.max(max, arr[i]);
		}

		if(arr[n-1] > max)
			count++;

		return count;
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