import java.io.*;
import java.util.*;

class Yoghurt{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);

		int count = 0;
		int j;
		int day = 1;

		for(int i = 0; i < n; i++)
		{
			if(arr[i] < day)
				continue;

			j = k;
			
			while(i < n && j-- > 0)
			{
				i++;
				count++;
			}

			i--;

			day++;
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