import java.io.*;
import java.util.*;

class CountThePoints{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];

		for(int i = 0; i < n; i++)
		{
			String[] st = br.readLine().split(" ");

			arr[i][0] = Integer.parseInt(st[0]);
			arr[i][1] = Integer.parseInt(st[1]);
		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}