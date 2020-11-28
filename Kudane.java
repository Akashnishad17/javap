import java.io.*;
import java.util.*;

class Kudane{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		long max_so_far = Long.MIN_VALUE;
		long max = 0;

		for(int x : arr)
		{
			max += x;
			if(max > max_so_far)
				max_so_far = max;

			if(max < 0)
				max = 0;
		}

		System.out.print(max_so_far);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}