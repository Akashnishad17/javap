import java.io.*;
import java.util.*;

class PositivePrefixes{

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		StringBuilder sb = new StringBuilder();
		int[] arr = new int[n+1];

		int rem = n - k;

		for(int i = 1; i <= n; i++)
			arr[i] = i;

		for(int i = 1; i <= n && rem > 0; i += 2)
		{
			arr[i] = -arr[i];
			rem--;
		}

		for(int i = (n/2) * 2; i >= 2 && rem > 0; i -= 2)
		{
			arr[i] = -arr[i];
			rem--;
		}

		for(int i = 1; i <= n; i++)
			sb.append(arr[i]+" ");

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