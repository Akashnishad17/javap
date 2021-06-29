import java.io.*;
import java.util.*;

class ProductTriplets{

	public static long nCr(long n, int r)
	{
		if(n < r)
			return 0;

		if(r == 2)
			return (n * (n - 1)) / 2;

		return (n * (n - 1) * (n-2)) / 6;
	}

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		long[] arr = new long[n];

		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st[i]);

		Arrays.sort(arr);

		int z = 0;
		while(z < n && arr[z] == 0)
			z++;

		long count = 0;

		HashMap<Long, Integer> map = new HashMap<>();

		for(int i = n-1; i >= z; i--)
		{
			for(int j = i-1; j >= z; j--)
				count += map.getOrDefault(arr[i]*arr[j], 0);

			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		count += nCr((long)z, 3);
		count += nCr((long)z, 2)*(n - z);

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