import java.io.*;
import java.util.*;

class PointOfImpact{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);
		int x = Integer.parseInt(st[2]);
		int y = Integer.parseInt(st[3]);

		if(x == y)
			return n + " " + n;

		if(x > y)
		{
			y += n - x;
			x = n;

			if(k % 4 == 1)
				return x + " " + y;
			if(k % 4 == 2)
				return y + " " + x;
			if(k % 4 == 3)
				return 0 + " " + (n - y);
			return (n - y) + " " + 0;
		}
		else
		{
			x += n - y;
			y = n;

			if(k % 4 == 1)
				return x + " " + y;
			if(k % 4 == 2)
				return y + " " + x;
			if(k % 4 == 3)
				return (n - x) + " " + 0;
			return 0 + " " + (n - x);
		}
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