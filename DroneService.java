import java.io.*;
import java.util.*;

class DroneService{
	public static HashMap<String, Long> map = new HashMap<>();

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long w1 = Long.parseLong(st[0]);
		long w2 = Long.parseLong(st[1]);

		int n = Integer.parseInt(st[2]);

		st = br.readLine().split(" ");

		long[] arr = new long[n];

		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st[i]);

		Arrays.sort(arr);

		return dfs(arr, n - 1, w1, w2);
	}

	public static long dfs(long[] arr, int index, long w1, long w2)
	{
		if(index < 0)
			return 0;

		if(w1 > w2)
		{
			long temp = w1;
			w1 = w2;
			w2 = temp;
		}

		String key = index + " " + w1 + " " + w2;

		if(map.containsKey(key))
			return map.get(key);

		long min = Long.MAX_VALUE;

		if(arr[index] <= w1)
			min = Math.min(min, dfs(arr, index - 1, w1 - arr[index], w2));

		if(arr[index] <= w2)
			min = Math.min(min, dfs(arr, index - 1, w1, w2 - arr[index]));

		min = Math.min(min, arr[index] + dfs(arr, index - 1, w1, w2));

		map.put(key, min);

		return min;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}