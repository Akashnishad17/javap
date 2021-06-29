import java.io.*;
import java.util.*;

class EvenDifferences{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		int x, even = 0, odd = 0;

		String[] st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
		{
			x = Integer.parseInt(st[i]);

			if(x % 2 == 0)
				even++;
			else
				odd++;
		}

		return Math.min(even, odd);
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