import java.io.*;
import java.util.*;

class MetalHarvest{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		int[][] arr = new int[n][2];

		for(int i = 0; i < n; i++)
		{
			st = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(st[0]);;
			arr[i][1] = Integer.parseInt(st[1]);;
		}

		Arrays.sort(arr, (a, b) -> a[1] - b[1]);

		int count = 0;

		int end = 0;

		for(int[] a : arr)
		{
			if(end >= a[1])
				continue;

			end = Math.max(end, a[0]);
			
			if((a[1] - end) % k == 0)
			{
				count += (a[1] - end)/k;
				end = a[1];
			}
			else
			{
				count += (a[1] - end)/k + 1;
				end = end + ((a[1] - end)/k + 1)*k;
			}
		}

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