import java.io.*;
import java.util.*;

class AdjacencyHatred{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		int l = 0, r = n - 1, num;

		for(String s : st)
		{
			num = Integer.parseInt(s);

			if(num % 2 == 0)
				arr[l++] = num;
			else
				arr[r--] = num;
		}

		if((int)Math.abs(arr[0] - arr[n-1]) % 2 == 0)
			return "-1";

		StringBuilder sb = new StringBuilder();

		for(int x : arr)
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