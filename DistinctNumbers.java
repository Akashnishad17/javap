import java.io.*;
import java.util.*;

class DistinctNumbers{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);

		int count = 0;

		for(int i = 0; i < n; i++)
		{
			while(i+1 < n && arr[i] == arr[i+1])
				i++;
			count++;
		}

		System.out.print(count);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}