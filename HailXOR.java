import java.io.*;
import java.util.*;

class HailXOR{

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");

		List<Queue<Integer>> ones = new ArrayList<>();

		for(int i = 0; i < 31; i++)
			ones.add(new LinkedList<>());

		int num;
		int[][] bin = new int[n][31];

		for(int i = 0; i < n; i++)
		{
			num = Integer.parseInt(st[i]);

			for(int j = 0; j < 31; j++)
			{
				if((num & (1 << (30 - j))) > 0)
				{
					bin[i][j] = 1;
					ones.get(j).add(i);
				}
			}
		}

		for(int i = 0; i < n-1 && x > 0; i++)
		{
			for(int j = 0; j < 31 && x > 0; j++)
			{
				if(bin[i][j] == 1)
				{
					ones.get(j).remove();
					x--;
					bin[i][j] = 0;

					if(ones.get(j).isEmpty())
						bin[n-1][j] ^= 1;
					else
						bin[ones.get(j).remove()][j] = 0;
				}
			}
		}

		if(n == 2 && x % 2 != 0)
		{
			bin[n-2][30] = 1;
			bin[n-1][30] ^= 1;
		}	

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; i++)
		{
			num = 0;

			for(int j = 0; j < 31; j++)
			{
				if(bin[i][j] == 1)
					num += 1 << (30 - j);
			}

			sb.append(num+" ");
		}

		System.out.println(sb.toString());
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

/*
5
3 3
2 2 3
5 3
6 6 5 13 8
2 3
0 0
7 3
7 6 5 4 3 2 1
8 10
1 2 3 4 3 2 1 0
*/