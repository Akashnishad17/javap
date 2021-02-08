import java.io.*;
import java.util.*;

class WatchingCPLBackUp{

	public static HashMap<String, Integer> map;

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);
		map = new HashMap<>();

		return dfs(arr, n-1, 0, 0, k, 0);
	}

	public static int dfs(int[] arr, int index, int t1, int t2, int k, int count)
	{
		if(t1 >= k && t2 >= k)
			return count;

		String s = index + " " + t1 + " " + t2;

		if(map.containsKey(s))
			return map.get(s);

		if(index == -1)
			return -1;

		int min1 = -1, min2 = -1;

		if(t1 == t2)
			min1 = dfs(arr, index - 1, t1 + arr[index], t2, k, count + 1);

		else
		{
			if(t1 < k)
				min1 = dfs(arr, index - 1, t1 + arr[index], t2, k, count + 1);

			if(t2 < k)
			{
				if(t2 + arr[index] < t1)
					min2 = dfs(arr, index - 1, t1, t2 + arr[index], k, count + 1);
				else
					min2 = dfs(arr, index - 1, t2 + arr[index], t1, k, count + 1);
			}
		}

		int res = -1;

		if(min1 == -1 && min2 == -1)
			res = -1;

		else if(min1 == -1)
			res = min2;

		else if(min2 == -1)
			res =  min1;
		else
			res =  Math.min(min1, min2);

		map.put(s, res);

		return res;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}