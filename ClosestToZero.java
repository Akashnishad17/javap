import java.io.*;
import java.util.*;

class ClosestToZero{

	// 0 -> neg, 1 -> pos;
	// 0 -> val, 1 -> sum_sign, 2 -> res_sign

	public static int not = 100000000;
	public static HashMap<String, int[]> map;
	
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		map = new HashMap<>();

		return dfs(arr, arr[0], 1);
	}

	public static int dfs(int[] arr, int sum, int index)
	{
		if(index == arr.length)
			return sum;

		String s = Math.abs(sum)+" "+index;

		if(map.containsKey(s))
		{
			int[] val = map.get(s);

			if(sum >= 0)
			{
				if(val[1] == 1)
					return val[2] == 1 ? val[0] : -val[0];

				return val[0];
			}
			else
			{
				if(val[1] == 0)
					return val[2] == 1 ? val[0] : -val[0];

				return val[0];
			}
		}

		int add = dfs(arr, sum + arr[index], index+1);
		int sub = dfs(arr, sum - arr[index], index+1);

		int abs1 = Math.abs(add);
		int abs2 = Math.abs(sub);

		int res = abs1 == abs2 ? (add == sub ? add : abs1) : (abs1 < abs2 ? add : sub);

		int[] val = new int[3];

		val[0] = Math.abs(res);
		val[1] = sum >= 0 ? 1 : 0;
		val[2] = res >= 0 ? 1 : 0;

		map.put(s, val);

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