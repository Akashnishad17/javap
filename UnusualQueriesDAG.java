import java.io.*;
import java.util.*;

class UnusualQueriesDAG{

	public static int n = 100010;

	public static int[] v, last, max, arr, bit, out;
	public static HashMap<Integer, HashMap<Integer, Integer>> map;

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);
		int s = Integer.parseInt(st[2]);

		st = br.readLine().split(" ");
		arr = new int[N];
		v = 

		for(int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(st[i]);

		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}