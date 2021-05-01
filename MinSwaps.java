import java.io.*;
import java.util.*;

class MinSwaps{
	public static long solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		int n = s.length();
		int count = 0;
		long res = 0;

		for(int i = n - 1; i >= 0; i--)
		{
			if(s.charAt(i) == '1')
				res += n - 1 - i - count++;
		}

		return res;
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