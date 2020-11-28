import java.io.*;
import java.util.*;

class ATMQueue{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int[][] arr = new int[n][2];

		int t;
		for(int i = 0; i < n; i++)
		{
			t = Integer.parseInt(st[i]);
			
			arr[i][1] = i + 1;
			arr[i][0] = t / x - (t % x == 0 ? 1 : 0);
		}

		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		StringBuilder sb = new StringBuilder();

		for(int[] a : arr)
			sb.append(a[1]+" ");

		return sb.toString();
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