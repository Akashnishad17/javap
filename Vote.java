import java.io.*;
import java.util.*;

class Vote{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		double n = Double.parseDouble(st[0]);
		double m = Double.parseDouble(st[1]);

		return (n - m) / (n + m);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}