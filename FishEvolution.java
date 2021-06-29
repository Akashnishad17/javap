import java.io.*;
import java.util.*;

class FishEvolution{
	
	public static String solve(int[] arr, int[] dir, int n)
	{
		int[] left = new int[n];
		int[] right = new int[n];

		for(int i = 1; i < n; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(dir[j] == 1 && arr[j] > arr[i] && left[j] + 1 > left[i])
					left[i] = left[j] + 1;
			}
		}

		for(int i = n - 2; i >= 0; i--)
		{
			for(int j = n-1; j > i; j--)
			{
				if(dir[j] == -1 && arr[j] > arr[i] &&right[j] + 1 > right[i])
					right[i] = right[j] + 1;
			}
		}

		int max = 0, value = 0, offset = 0;

		for(int i = 0; i < n; i++)
		{	
			if(dir[i] == -1)
			{
				if(max < left[i])
				{
					max = left[i];
					value = arr[i];
					offset = -1;
				}
				
				else if(max == left[i])
				{
					value = Math.max(arr[i], value);
					offset = -1;
				}
			}
			else
			{
				if(max < right[i])
				{
					max = right[i];
					value = arr[i];
					offset = 1;
				}
				
				else if(max == right[i])
				{
					value = Math.max(arr[i], value);
					offset = 1;
				}
			}
		}

		return value + " " + (offset == 1 ? "right" : "left");
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0)
		{
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			int[] dir = new int[n];

			String[] st = br.readLine().split(" ");

			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st[i]);

			st = br.readLine().split(" ");
			
			for(int i = 0; i < n; i++)
				dir[i] = Integer.parseInt(st[i]);

			System.out.println(solve(arr, dir, n));
		}
	}
}