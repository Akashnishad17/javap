import java.io.*;
import java.util.*;

class HillSequence{

	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		HashMap<Integer,Integer> map = new HashMap<>();
		int num;
		int max = 0;
		boolean valid = true;

		for(int i = 0; i < n && valid; i++)
		{
			num = Integer.parseInt(st[i]);
			map.put(num, map.getOrDefault(num, 0) + 1);
			max = Math.max(num, max);
			if((int)map.get(num) > 2)
				valid = false;
		}


		if(map.get(max) > 1)
			valid = false;

		if(!valid)
			sb.append("-1\n");
		else
		{
			List<Integer> doubles = new ArrayList<>();
			List<Integer> singles = new ArrayList<>();

			for(Map.Entry<Integer, Integer> e: map.entrySet())
			{
				if((int)e.getValue() == 2)
					doubles.add(e.getKey());

				singles.add(e.getKey());
			}

			Collections.sort(singles);
			Collections.sort(doubles);

			for(int x : doubles)
				sb.append(x+" ");

			for(int i = singles.size() - 1; i >= 0; i--)
				sb.append(singles.get(i)+" ");

			sb.append("\n");
		}
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
			solve(br);

		System.out.print(sb.toString());
	}
}