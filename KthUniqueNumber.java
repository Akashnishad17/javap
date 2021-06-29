import java.io.*;
import java.util.*;

class KthUniqueNumber{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int x = Integer.parseInt(st[1]);
		long k = Long.parseLong(st[2]);

		String s = br.readLine();

		int block = n/x + (n % x == 0 ? 0 : 1);

		int[][] freq = new int[block][10];
		long[] suffix = new long[block+1];
		suffix[block] = 1;

		int b = -1;

		for(int i = 0; i < s.length(); i++)
		{
			if(i % x == 0)
				b++;

			int num = s.charAt(i) - '0';

			if(freq[b][num] == 0)
			{
				freq[b][0]++;
				freq[b][num] = 1;
			}
		}

		int[][] blocks = new int[block][];

		for(int i = 0; i < block; i++)
		{
			suffix[i] = freq[i][0];
			blocks[i] = new int[freq[i][0]];

			int index = 0;

			for(int j = 1; j < 10; j++)
			{
				if(freq[i][j] == 0)
					continue;

				blocks[i][index++] = j;
			}
		}

		for(int i = block - 1; i >= 0; i--)
			suffix[i] *= suffix[i+1];

		String res = dfs(blocks, suffix, 1, k, "", 0, block);
		System.out.println(res);
	}

	public static String dfs(int[][] blocks, long[] suffix, long temp, long k, String s, int index, int block)
	{
		if(index == block)
			return s;

		for(int i = 0; i < blocks[index].length; i++)
		{
			long l = temp * i * suffix[index+1] + 1;
			long r = temp * (i + 1) * suffix[index+1];

			if(l <= k && k <= r)
				return dfs(blocks, suffix, temp*(i+1), k, s + blocks[index][i], index+1, block);
		}

		return "";
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));	
		solve(br);
	}
}