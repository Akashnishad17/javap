import java.io.*;
import java.util.*;

class BinarySubsequence{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String s = br.readLine();

		int[] prefix0 = new int[n+1];
		int[] prefix1 = new int[n+1];

		for(int i = 1; i <= n; i++)
		{
			if(s.charAt(i-1) == '1')
				prefix1[i]++;
			else
				prefix0[i]++;

			prefix0[i] += prefix0[i-1];
			prefix1[i] += prefix1[i-1];
		}

		int min = n;
		int count;

		for(int i = 1; i <= n; i++)
		{
			if(s.charAt(i-1) == '0')
			{
				count = prefix1[i] + Math.min(prefix1[n] - prefix1[i], prefix0[n] - prefix0[i]);
				min = Math.min(count, min);
			}
			else
			{
				count = prefix0[n] - prefix0[i] + Math.min(prefix0[i-1], prefix1[i-1]);
				min = Math.min(count, min);
			}

		}

		return min;
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