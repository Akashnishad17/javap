import java.io.*;
import java.util.*;

class SubarrayPermutations{
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		if(k == 1)
			sb.append(n == 1 ? "1\n" : "-1\n");
		else
		{
			int[] arr = new int[n];

			for(int i = 0; i < k - 1; i++)
				arr[i] = i + 1;

			for(int i = k - 1; i < n; i++)
				arr[i] = n - i + k - 1;

			for(int x : arr)
				sb.append(x + " ");

			sb.append("\n");
		}
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		

		while(t-- > 0)
			solve(br);

		System.out.print(sb.toString());
	}
}