import java.io.*;
import java.util.*;

class WiggleWalk{

	public static void update(HashMap<Integer, TreeMap<Integer, Integer>> map, int x, int y)
	{
		TreeMap<Integer, Integer> tree;

		if(map.containsKey(x))
		{
			tree = map.get(x);
			
			Integer low = tree.lowerKey(y);
			Integer high = tree.higherKey(y);

			if(low != null)
			{
				if((int)tree.get(low) < y-1)
					low = y;
				
				tree.put(low, y);
			}
			else
			{
				low = y;
				tree.put(low,y);
			}

			if(high != null)
			{
				if((int)high == y+1)
				{
					tree.put(low, tree.get(high));
					tree.remove(high);
				}
			}
		}

		else
		{
			tree = new TreeMap<>();
			tree.put(y,y);
			map.put(x, tree);
		}
	}

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		
		int n = Integer.parseInt(st[0]);
		int r = Integer.parseInt(st[1]);
		int c = Integer.parseInt(st[2]);
		int sr = Integer.parseInt(st[3]);
		int sc = Integer.parseInt(st[4]);

		String s = br.readLine();

		HashMap<Integer, TreeMap<Integer, Integer>> rows  = new HashMap<>();
		HashMap<Integer, TreeMap<Integer, Integer>> cols  = new HashMap<>();
		TreeMap<Integer, Integer> tree;

		char ch;
		int tr, tc;
		Integer temp;

		for(int i = 0; i < n; i++)
		{
			ch = s.charAt(i);
			tr = sr;
			tc = sc;

			if(ch == 'E')
			{
				if(rows.containsKey(sr))
				{
					tree = rows.get(sr);
					temp = tree.higherKey(sc);
					
					if(temp == null || (int)temp > sc+1)
						sc++;
					else
						sc = tree.get(temp) + 1;
				}
				else
					sc++;
			}

			else if(ch == 'W')
			{
				if(rows.containsKey(sr))
				{
					tree = rows.get(sr);
					temp = tree.lowerKey(sc);
					
					if(temp == null || (int)tree.get(temp) < sc-1)
						sc--;
					else
						sc = (int)temp - 1;
				}
				else
					sc--;
			}

			else if(ch == 'S')
			{
				if(cols.containsKey(sc))
				{
					tree = cols.get(sc);
					temp = tree.higherKey(sr);
					
					if(temp == null || (int)temp > sr+1)
						sr++;
					else
						sr = tree.get(temp) + 1;
				}
				else
					sr++;
			}

			else
			{
				if(cols.containsKey(sc))
				{
					tree = cols.get(sc);
					temp = tree.lowerKey(sr);
					
					if(temp == null || (int)tree.get(temp) < sr-1)
						sr--;
					else
						sr = (int)temp - 1;
				}
				else
					sr--;
			}

			update(rows, tr, tc);
			update(cols, tc, tr);
		}

		return "" + sr +" " + sc;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}