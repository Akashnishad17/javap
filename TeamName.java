import java.io.*;
import java.util.*;

class TeamName{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		List<HashSet<String>> set = new ArrayList<>();

		for(int i = 0; i < 26; i++)
			set.add(new HashSet<>());

		for(String s : st)
			set.get(s.charAt(0) - 'a').add(s.substring(1, s.length()));

		long size1, size2;

		long pairs = 0;

		for(int i = 0; i < 25; i++)
		{
			for(int j = i + 1; j < 26; j++)
			{
				size1 = set.get(i).size();
				size2 = set.get(j).size();

				for(String s : set.get(i))
				{
					if(set.get(j).contains(s))
					{
						size1--;
						size2--;
					}
				}

				pairs += size1 * size2 * 2;
			}
		}

		return pairs;
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