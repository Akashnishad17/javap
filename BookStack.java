import java.io.*;
import java.util.*;

class BookStack{

	public static int gcd(int a, int b)
	{
		return a == 0 ? b : gcd(b % a, a);
	}

	public static int solve(int[] arr, int n)
	{
		int res = arr[0];

		for(int i = 1; i < n; i++)
			res = gcd(res, arr[i]);

		return res;
	} 

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			String[] st = br.readLine().split(" ");

			int[] arr = new int[n];

			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st[i]);
			System.out.println(solve(arr, n));
		}
	}
}