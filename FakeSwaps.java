import java.io.*;
import java.util.*;

class FakeSwaps{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String s = br.readLine();
		String p = br.readLine();

		if(s.equals(p))
			return "Yes";

		int one = 0, zero = 0;

		for(int i = 0; i < n; i++)
		{
			if(p.charAt(i) == '0')
				zero++;
			else
				one++;
		}

		return zero == n || one == n ? "No" :"Yes";
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