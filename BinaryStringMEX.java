import java.io.*;
import java.util.*;

class BinaryStringMEX{
	
	public static String solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		TreeSet<Integer> set = new TreeSet<>();
		dfs(0, s, 0, set, false);

		int num = 0;

		for(int x : set)
		{
			if(x != num)
				break;

			num++;
		}

		StringBuilder sb = new StringBuilder();

		if(num == 0)
			sb.append("0");

		while(num > 0)
		{
			sb.insert(0, num % 2);
			num /= 2;
		}

		return sb.toString();
	}

	public static void dfs(int index, String s, int num, TreeSet<Integer> set, boolean flag)
	{
		if(index == s.length())
		{
			if(flag)
				set.add(num);

			return;
		}

		dfs(index+1, s, num * 2 + (s.charAt(index) - '0'), set, true);
		dfs(index+1, s, num, set, flag);
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