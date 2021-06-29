import java.io.*;
import java.util.*;

class RestoreSequence{

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int[] arr = new int[n+1];

		for(int i = 0; i < n; i++)
			arr[i+1] = Integer.parseInt(st[i]);

		int[] res = new int[n+1];

		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = n; i > 0; i--)
		{
			if(arr[i] == i)
				res[i] = count++;

			else if(arr[i] > i)
				res[i] = res[arr[i]];

			sb.insert(0, res[i]+" ");
		}

		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}