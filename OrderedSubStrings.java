import java.io.*;
import java.util.*;

class OrderedSubStrings{
	
	public static void solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		TreeSet<String> set = new TreeSet<>();

		for(int i = 0; i < s.length(); i++)
		{
			StringBuilder sb = new StringBuilder();
			
			for(int j = i; j < s.length(); j++)
			{
				sb.append(s.charAt(j));
				set.add(sb.toString());
			}
		};

		int rank = 1;

		for(String e : set)
		{
			if(s.equals(e))
				break;

			rank++;
		}

		System.out.println(rank);
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