import java.io.*;
import java.util.*;

class FourEquidistant {
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int d = Integer.parseInt(br.readLine());

		if(d % 2 == 1)
			sb.append("-1\n");
		else
		{
			d /= 2;

			sb.append(d + " 0\n");
			sb.append((-d) + " 0\n");
			sb.append("0 " + d + "\n");
			sb.append("0 " + (-d) + "\n");
		}
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);

		System.out.print(sb.toString());
	}
}