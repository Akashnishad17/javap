import java.io.*;
import java.util.*;

class MaximumDistinctCharacters{
	
	public static void solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		HashSet<Character> set = new HashSet<>();

		for(int i = 0; i < s.length(); i++)
			set.add(s.charAt(i));

		int max = set.size();

		HashMap<Character,Integer> map = new HashMap<>();

		int a = 0, b = 0;

		int min = Integer.MAX_VALUE;

		while(a < s.length() && b < s.length())
		{

			if(map.size() < max)
			{
				map.put(s.charAt(b), map.getOrDefault(s.charAt(b), 0) + 1);
				b++;
			}
			if(map.size() == max)
			{
				min = Math.min(min, b - a);
				map.put(s.charAt(a), map.getOrDefault(s.charAt(a), 0) - 1);

				if((int)map.get(s.charAt(a)) == 0)
					map.remove(s.charAt(a));

				a++;
			}
		}

		while(a < s.length())
		{
			if(map.size() == max)
			{
				min = Math.min(min, b - a);
				map.put(s.charAt(a), map.getOrDefault(s.charAt(a), 0) - 1);

				if((int)map.get(s.charAt(a)) == 0)
					map.remove(s.charAt(a));
			}
			a++;
		}

		System.out.print(min);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}