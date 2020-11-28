import java.io.*;
import java.util.*;

class ChefQueries{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		long k = sc.nextLong();

		long[] arr = new long[n];
		int i;

		for(i = 0; i < n; i++)
			arr[i] = sc.nextLong();

		i = 0;
		long count = 0;
		long res = 0;
		
		while(i < n)
		{
			count += arr[i];
			if(count < k)
				break;
			count -= k;
			i++;
			res++;
		}

		if(count > k)
			res += count/k;

		System.out.println(res+1);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
			solve(sc);
	}
}