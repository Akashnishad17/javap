import java.io.*;
import java.util.*;

class PermutationXority{
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		if(n == 2)
			sb.append("-1\n");
		else
		{
			int[] arr = new int[n];

			for(int i = 0; i < n; i++)
				arr[i] = i + 1;

			if(n % 2 == 0)
			{
				arr[n - 1] = n - 1;
				arr[n - 2] = n - 2;
				arr[n - 3] = n;
			}

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