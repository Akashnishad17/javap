import java.io.*;
import java.util.*;

class AlienPiano{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int count = 0;
		int up = 0, down = 0;

		for(int i = 1; i < n; i++)
		{
			if(arr[i-1] < arr[i])
			{
				up++;
				down = 0;
			}

			else if(arr[i-1] > arr[i])
			{
				down++;
				up = 0;
			}

			if(down > 3 || up > 3)
			{
				count++;
				up = 0;
				down = 0;
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