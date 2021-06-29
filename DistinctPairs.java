import java.io.*;
import java.util.*;

class DistinctPairs{
	public static int solve(int[] arr)
	{
		HashSet<Integer> set = new HashSet<>();

		for(int i = 0; i < arr.length; i++)
			set.add(arr[i]);

		long size = set.size();

		return (int)((size * size) % 1000000007);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		System.out.print(solve(arr));
	}
}