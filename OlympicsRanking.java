import java.io.*;
import java.util.*;

class OlympicsRanking{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int m1 = 0, m2 = 0;

		for(int i = 0; i < 3; i++)
		{
			m1 += Integer.parseInt(st[i]);
			m2 += Integer.parseInt(st[i+3]);
		}

		return m1 > m2 ? 1 : 2;
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