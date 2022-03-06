import java.io.*;
import java.util.*;

class AlternatingDivisibility{
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int count = n/2;

		for(int i = n; count > 0; count--, i--)
			sb.append(i + " " + (2 * i) + " ");

		if(n % 2 == 1)
			sb.append("1 ");

		sb.append("\n");
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		

		while(t-- > 0)
			solve(br);

		System.out.print(sb.toString());
	}
}