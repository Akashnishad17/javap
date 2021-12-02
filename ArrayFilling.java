import java.io.*;
import java.util.*;

class ArrayFilling{
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] arr = new int[m][2];

		for(int i = 0; i < m; i++)
		{
			st = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(st[0]);
			arr[i][1] = Integer.parseInt(st[1]);
		}

		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);

		long res = 0;
		long left = n;
		long lcm = 1;

		for(int i = 0; i < m && left > 0; i++)
		{
			lcm = (lcm * arr[i][1])/gcd(lcm, arr[i][1]);
			res += (left - n/lcm) * arr[i][0];
			left = n/lcm;
		}

		return res;
	}

	public static long gcd(long a, long b)
	{
		return a == 0 ? b : gcd(a % b, a);
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