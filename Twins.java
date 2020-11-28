import java.io.*;
import java.util.*;

class Twins{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		int i;
		
		for(i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		int count = 0;
		i = n - 1;
		int countSum = 0;
		
		while(i >= 0 && countSum <= sum/2)
		{
			countSum += arr[i--];
			count++;
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input4.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
		{
			solve(sc);
		}
	}
}