import java.io.*;
import java.util.*;

class SpaceArrays{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long real = ((long)n * (n + 1))/2;
		long expected = 0;

		int[] suffix =  new int[n+2];


		for(String s : st)
		{
			int x = Integer.parseInt(s);
			suffix[x]++;
			expected += x;
		}

		if(expected > real)
			return "Second";

		for(int i = n; i >= 1; i--)
		{
			suffix[i] += suffix[i+1];

			if(suffix[i] > n - i + 1)
				return "Second";
		}

		return (real - expected) % 2 == 1 ? "First" : "Second";
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