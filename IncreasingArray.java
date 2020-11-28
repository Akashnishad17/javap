import java.io.*;
import java.util.*;

class IncreasingArray{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		long min = 0;

		for(int i = 1; i < n; i++)
		{
			if(arr[i-1] > arr[i])
			{
				min += arr[i-1] - arr[i];
				arr[i] = arr[i-1];
			}
		}

		System.out.print(min);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));

		solve(sc);
	}
}