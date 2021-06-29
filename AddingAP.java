import java.io.*;
import java.util.*;

class AddingAP{

	public static int mod = 1000000007;

	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long[] arr = new long[n];

		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(st[i]);

		int q = Integer.parseInt(br.readLine());


		while(q-- > 0)
		{
			st = br.readLine().split(" ");

			int l = Integer.parseInt(st[0]);
			int r = Integer.parseInt(st[1]);

			long a = Long.parseLong(st[2]);
			long d = Long.parseLong(st[3]);

			for(int i = l - 1; i < r; i++)
			{
				arr[i] = (arr[i] + a) % mod;
				a = (a + d) % mod;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(long x : arr)
			sb.append(x+" ");

		return sb.toString();
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