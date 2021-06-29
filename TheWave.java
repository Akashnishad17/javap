import java.io.*;
import java.util.*;

class TheWave{
	public static void solve(BufferedReader br) throws Exception
	{
		StringBuilder sb = new StringBuilder();

		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);
		int x, index;

		while(q-- > 0)
		{
			x = Integer.parseInt(br.readLine());

			index = lowerBound(arr, 0, n, x);

			if(index < n && arr[index] == x)
				sb.append("0\n");
			else
			{
				String res = (n - index) % 2 == 0 ? "POSITIVE" : "NEGATIVE";
				sb.append(res+"\n");
			}
		}

		System.out.print(sb.toString());
	}

	public static int lowerBound(int[] arr, int l, int r, int x)
	{
		int mid;

		while(l < r)
		{
			mid = l + (r - l)/2;

			if(x - arr[mid] <= 0)
				r = mid;
			else
				l = mid + 1;
		}

		return l;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		while(t-- > 0)
			solve(br);
	}
}