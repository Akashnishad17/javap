import java.io.*;
import java.util.*;

class VaccineStock{

	public static String dfs(int[] cost, int index, int n, String num)
	{
		if(n == 0)
			return num;

		if(index == 0)
			return "";

		String res = dfs(cost, index-1, n, num);;
		String temp;

		while(n >= cost[index])
		{
			n -= cost[index];
			num += index;
			temp = dfs(cost, index-1, n, num);

			if(temp.compareTo(res) > 0)
				res = temp;
		}
		
		return res;	
	}

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int[] cost = new int[10];
		String[] st = br.readLine().split(" ");

		for(int i = 1; i < 10; i++)
			cost[i] = Integer.parseInt(st[i-1]);

		String res = dfs(cost, 9, n, "");

		if(res.equals(""))
			res = "-1";

		System.out.println(res);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}