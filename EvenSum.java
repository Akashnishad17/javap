import java.io.*;
import java.util.*;

class EvenSum{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		long sum = 0;
		int x;

		for(int i = 0; i < n; i++)
		{
			x = Integer.parseInt(st[i]);

			if(i % 2 == 0)
			{
				if((sum + x) % 2 == 0)
					sum += x;
				else if((sum - x) % 2 == 0)
					sum -= x;
				else
					sum += x;
			}
			else
			{
				if((sum + x) % 2 == 1)
					sum += x;
				else if((sum - x) % 2 == 1)
					sum -= x;
				else
					sum += x;
			}
		}

		return sum % 2 == 0 ? 1 : 2;
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