import java.io.*;
import java.util.*;

class SubsegmentDivisibility{
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		arr[0] = 1;

		if(n > 1)
		{
			arr[1] = 2;
			for(int i = 2; i < n; i++)
				arr[i] = arr[i - 2] + 4;
		}

		for(int x : arr)
			sb.append(x + " ");

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