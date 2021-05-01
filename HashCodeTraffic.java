import java.io.*;
import java.util.*;

class HashCodeTraffic{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int d = Integer.parseInt(st[0]); 	//simulation time
		int in = Integer.parseInt(st[1]); 	//intersections
		int s = Integer.parseInt(st[2]); 	//streets
		int v = Integer.parseInt(st[3]);	//cars
		int f = Integer.parseInt(st[4]);	//bonus

		HashMap<Integer,List<String>> map = new HashMap<>();

		for(int i = 0; i < s; i++)
		{
			st = br.readLine().split(" ");
			List<String> list = map.getOrDefault(Integer.parseInt(st[1]), new ArrayList<>());
			list.add(st[2]);
			map.put(Integer.parseInt(st[1]), list);
		}

		for(int i = 0; i < v; i++)
			br.readLine();

		StringBuilder sb = new StringBuilder();

		sb.append(map.size()+"\n");

		for(int i = 0; i < in; i++)
		{
			List<String> list = map.getOrDefault(i, new ArrayList<>());

			if(list.size() > 0)
			{
				sb.append(list.size()+"\n");
				for(String str : list)
					sb.append(str+" 1\n");
			}
		}

		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("d.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}