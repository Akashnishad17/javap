import java.io.*;
import java.util.*;

class Charges{
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		String s = br.readLine();

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = s.charAt(i) - '0';

		int sum = 0;

		for(int i = 0; i < n - 1; i++)
		{
			sum++;
			
			if(arr[i] == arr[i+1])
				sum++;
		}

		st = br.readLine().split(" ");
		int index;

		for(String x : st)
		{
			index = Integer.parseInt(x) - 1;

			if(index - 1 >= 0)
			{
				if(arr[index] == arr[index-1])
					sum--;
				else
					sum++;
			}

			if(index + 1 < n)
			{
				if(arr[index] == arr[index+1])
					sum--;
				else
					sum++;
			}

			arr[index] ^= 1;

			sb.append(sum+"\n");
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