import java.io.*;
import java.util.*;

class StringOperations{

	public static HashMap<String,Integer> map;

	public static void generate(String s)
	{
		if(map.containsKey(s))
			return;

		map.put(s, map.getOrDefault(s, 0) + 1);
		int count;

		for(int i = 0; i < s.length(); i++)
		{
			count = 0;

			for(int j = i; j < s.length(); j++)
			{

				if(s.charAt(j) == '1')
					count++;

				if(count % 2 == 0)
					generate(reverse(s, i, j));
			}
		}
	}

	public static String reverse(String s, int l, int r)
	{
		String res = "";

		for(int i = 0; i < l; i++)
			res += s.charAt(i);

		for(int i = r; i >= l; i--)
			res += s.charAt(i);

		for(int i = r+1; i < s.length(); i++)
			res += s.charAt(i);

		return res;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		int res = 0;
		String s = br.readLine();

		map = new HashMap<>();

		for(int i = 0; i < s.length(); i++)
		{
			StringBuilder sb = new StringBuilder();
			for(int j = i; j < s.length(); j++)
			{
				sb.append(s.charAt(j));

				if(!map.containsKey(sb.toString()))
				{
					res++;
					generate(sb.toString());
				}
			}
		}

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