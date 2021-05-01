import java.io.*;
import java.util.*;

class AllMinPairs{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;

		List<int[]> list = new ArrayList<>();

		for(int i = 1; i < n; i++)
		{
			if(arr[i] - arr[i-1] < min)
			{
				min = arr[i] - arr[i-1];
				list.clear();
			}

			if(arr[i] - arr[i-1] == min)
				list.add(new int[]{arr[i-1], arr[i]});
		}

		for(int[] t : list)
			System.out.print(t[0]+" "+t[1]+" ");
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}