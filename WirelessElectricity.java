import java.io.*;
import java.util.*;

class WirelessElectricity{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		for(int i = 0; i < n; i++)
			br.readLine().split(" ");

		StringBuilder sb = new StringBuilder();
		int a, b, c, d, temp;

		for(int i = 0; i < m; i++)
		{
			st = br.readLine().split(" ");

			a = Integer.parseInt(st[0]);
			b = Integer.parseInt(st[1]);
			c = Integer.parseInt(st[2]);
			d = Integer.parseInt(st[3]);

			if(a > c)
			{
				temp = a;
				a = c;
				c = temp;

				temp = b;
				b = d;
				d = temp;
			}

			if(i % 2 == 0)
				sb.append((-a) + " " + (-b - 1) + "\n");
			else
				sb.append((1000001 - a) + " " + (1000000 - b) + "\n");
		}

		System.out.print(sb.toString());
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}