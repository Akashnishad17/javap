import java.io.*;
import java.util.*;

class CarsandBikes{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		return n % 4 == 0 ? "NO" : "Yes";
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