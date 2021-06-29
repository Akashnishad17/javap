import java.io.*;
import java.util.*;

class IronMagnet{

	public static int countMagnet(String s, int k)
	{
		if(s.length() <= 1)
			return 0;

		int n = s.length();

		int[] con = new int[n+1];
		List<Integer> iron = new ArrayList<>();
		List<Integer> metal = new ArrayList<>();

		char c;
		for(int i = 1; i <= n; i++)
		{
			c = s.charAt(i-1);

			con[i] = con[i-1];
			
			if(c == 'I')
				iron.add(i);

			else if(c == 'M')
				metal.add(i);

			else if(c == ':')
				con[i]++;
		}

		int x = 0, y = 0, i, j;

		int p, sij;
		int count = 0;

		while(x < iron.size() && y < metal.size())
		{
			i = iron.get(x);
			j = metal.get(y);

			sij = i < j ? con[j] - con[i] : con[i] - con[j];

			p = k + 1 - Math.abs(i - j) - sij;

			if(p <= 0)
			{
				if(i < j)
					x++;
				else
					y++;
			}
			else
			{
				count++;
				x++;
				y++;
			}
		}

		return count;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);
		
		st = br.readLine().split("X");

		int count = 0;
		for(String s : st)
			count += countMagnet(s, k);

		System.out.println(count);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}