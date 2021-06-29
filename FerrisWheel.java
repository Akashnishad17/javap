import java.io.*;
import java.util.*;

class FerrisWheel{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);

		int l = 0, r = n-1;
		int count = 0;

		while(l < r)
		{
			if(arr[l] + arr[r] <= x)
				l++;

			r--;
			count++;
		}

		if(l == r)
			count++;

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