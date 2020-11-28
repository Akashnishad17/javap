import java.io.*;
import java.util.*;

class ArrayDivision{

	public static long max = 0;

	public static void helper(int[] arr, int index, int n, long sum, long target)
	{
		if(index == n)
		{
			if(sum <= target && sum > max)
				max = sum;
			return;
		}

		helper(arr, index+1, n, sum, target);
		helper(arr, index+1, n, sum + arr[index], target);
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();

		int[] arr = new int[n];
		long sum = 0;
		
		for(int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		helper(arr, 0, n, 0, sum/2);
		System.out.print(sum - 2 * max);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}