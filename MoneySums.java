import java.io.*;
import java.util.*;

class MoneySums{
	//public static TreeSet<Integer> set = new TreeSet<>();
	public static int[] res = new int[100001];
	public static int count = 0;
	public static HashSet<String> dp = new HashSet<>();

	public static void solve(int[] arr, int index, int n, int sum)
	{
		if(index == n)
		{
			if(res[sum] == 0)
				count++;
			res[sum] = 1;
			return;
		}

		String pat = "" + index + "-" + sum;
		if(dp.contains(pat))
			return;

		solve(arr, index+1, n, sum);
		solve(arr, index+1, n, sum + arr[index]);

		dp.add(pat);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.setOut(new PrintStream(new File("output.txt")));

		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);
		solve(arr, 0, n, 0);

		System.out.println(--count);
		for(int i = 1; i <= 100000; i++)
		{
			if(res[i] == 1)
				System.out.print(i+" ");
		}
	}
}