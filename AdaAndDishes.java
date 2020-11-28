import java.io.*;
import java.util.*;

class AdaAndDishes{

	public static int dfs(int[] arr, int index, int t1, int t2, int n)
	{
		if(index == n)
			return Math.max(t1, t2);

		int left = dfs(arr, index+1, t1 + arr[index], t2, n);
		int right = dfs(arr, index+1, t1, t2 + arr[index], n);

		return Math.min(left, right);
	}

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		System.out.println(dfs(arr, 0, 0, 0, n));
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}