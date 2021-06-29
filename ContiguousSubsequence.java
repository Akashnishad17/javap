import java.io.*;
import java.util.*;

class ContiguousSubsequence{

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());;

		int[] arr = new int[n];
		String[] st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}