import java.io.*;
import java.util.*;

class UnpleasantOnes{
	
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		int l = 0, r = n - 1, x;

		for(String s : st)
		{
			x = Integer.parseInt(s);

			if(x % 2 == 0)
				arr[l++] = x;
			else
				arr[r--] = x;
		}

		for(int a : arr)
			sb.append(a+" ");

		sb.append("\n");
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