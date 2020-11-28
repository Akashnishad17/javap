import java.io.*;
import java.util.*;

class FavGenre{

	public static HashMap<String, List<String>> favoriteVideoGenre(int numUsers, HashMap<String, List<String>> userBookListenedTo, int numGenres, HashMap<String, List<String>> bookGenres)
	{
		HashMap<String, String> reverseMap = new HashMap<>();

		for(Map.Entry<String, List<String>> e : bookGenres.entrySet())
		{
			for(String book : e.getValue())
				reverseMap.put(book, e.getKey());
		}

		HashMap<String, List<String>> res = new HashMap<>();

		for(Map.Entry<String, List<String>> e : userBookListenedTo.entrySet())
		{
			HashMap<String, Integer> counts = new HashMap<>();
			int max = 0;

			for(String book : e.getValue())
			{
				String gen = reverseMap.get(book);
				counts.put(gen, counts.getOrDefault(gen, 0) + 1);
				max = Math.max(max, (int)counts.get(gen));
			}

			List<String> list = new ArrayList<>();
			for(Map.Entry<String, Integer> t : counts.entrySet())
			{
				if(max == (int)t.getValue())
					list.add(t.getKey());
			}

			res.put(e.getKey(), list);
		}

		return res;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int numUsers = Integer.parseInt(st[0]);
		int numGenres = Integer.parseInt(st[1]);

		HashMap<String, List<String>> userBookListenedTo = new HashMap<>();
		HashMap<String, List<String>> bookGenres = new HashMap<>();

		for(int j = 0; j < numUsers; j++)
		{
			st = br.readLine().split(" ");
			List<String> list = new ArrayList<>();

			for(int i = 1; i < st.length; i++)
				list.add(st[i]);

			userBookListenedTo.put(st[0], list);
		}

		for(int j = 0; j < numGenres; j++)
		{
			st = br.readLine().split(" ");
			List<String> list = new ArrayList<>();

			for(int i = 1; i < st.length; i++)
				list.add(st[i]);

			bookGenres.put(st[0], list);
		}

		HashMap<String, List<String>> res = favoriteVideoGenre(numUsers, userBookListenedTo, numGenres, bookGenres);

		System.out.print(res);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}