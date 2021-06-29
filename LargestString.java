import java.io.*;
import java.util.*;

class LargestString{
	public static void solve(Scanner sc)
	{
		int[] cost = new int[26];
		for(int i = 0; i < 26; i++)
			cost[i] = sc.nextInt();
		int weight = sc.nextInt();
		String res = "";
		for(int i = 25; i >= 0; i--)
		{
			while(cost[i] <= weight)
			{
				res += (char)(i + 'a');
				weight -= cost[i];
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input3.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
		{
			solve(sc);
		}
	}
}