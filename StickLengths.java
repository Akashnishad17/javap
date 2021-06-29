import java.io.*;
import java.util.*;

class StickLengths{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);

		int l = 0, r = n - 1;
		long cost = 0;

		while(l < r)
			cost += arr[r--] - arr[l++];

		System.out.print(cost);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}