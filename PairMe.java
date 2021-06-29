import java.io.*;
import java.util.*;

class PairMe{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int x = Integer.parseInt(st[0]);
		int y = Integer.parseInt(st[1]);
		int z = Integer.parseInt(st[2]);

		if(x + y == z || y + z == x || x + z == y)
			return "YES";

		return "NO";
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