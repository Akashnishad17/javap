import java.io.*;
import java.util.*;

class NonComprimeNeighbours{
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int count = 0;

		for(int i = 1; i < n; i++)
		{
			if(gcd(arr[i-1], arr[i]) == 1)
			{
				if(i == n - 1)
					arr[i] = arr[i-1];
				else
				{
					int g = gcd(arr[i-1], arr[i+1]);
					
					arr[i] = g == 1 ? arr[i-1] : g;
				}

				count++;
			}
		}

		int limit = (2 * n) / 3 + ((2 * n) % 3 == 0 ? 0 : 1);

		if(count > limit)
			throw new Exception("Limit crossed");

		for(int i = 0; i < n; i++)
			sb.append(arr[i] + " ");

		sb.append("\n");
	}

	public static int gcd(int a, int b)
	{
		return a == 0 ? b : gcd(b % a, a);
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