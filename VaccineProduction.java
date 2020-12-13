import java.io.*;
import java.util.*;

class VaccineProduction{

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int d1 = Integer.parseInt(st[0]);
		int v1 = Integer.parseInt(st[1]);
		int d2 = Integer.parseInt(st[2]);
		int v2 = Integer.parseInt(st[3]);
		int p = Integer.parseInt(st[4]);

		int day = Math.min(d1, d2) - 1;

		int total = 0;

		while(total < p)
		{
			if(d1 < d2)
			{
				total += v1;
				d1++;
			}
			else if(d2 < d1)
			{
				total += v2;
				d2++;
			}
			else
				total += v1 + v2;

			day++;
		}

		System.out.print(day);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));

		solve(br);
	}
}