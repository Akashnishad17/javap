import java.io.*;
import java.util.*;

class MaximumTopologicalSortBackUp{

	public static int mod = 1000000007;

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		int[] freq = new int[n+1];

		for(int i = 0; i < n-1; i++)
		{
			st = br.readLine().split(" ");
			freq[Integer.parseInt(st[0])]++;
			freq[Integer.parseInt(st[1])]++;
		}

		long[] fact = new long[n+1];
		fact[0] = 1;

		int leaf = 0;

		for(int i = 1; i <= n; i++)
		{
			fact[i] = (fact[i-1] * i) % mod;
			
			if(freq[i] == 1)
				leaf++;
		}

		int max1 = 0, max2 = 0, index1 = 0, index2 = 0;

		for(int i = 1; i <= n; i++)
		{
			if(freq[i] == 1)
			{
				if(leaf - 1 >= max1)
				{
					max2 = max1;
					index2 = index1;

					max1 = leaf - 1;
					index1 = i;
				}
				else if(leaf - 1 >= max2)
				{
					max2 = leaf - 1;
					index2 = i;
				}
			}
			else
			{
				if(leaf >= max1)
				{
					max2 = max1;
					index2 = index1;

					max1 = leaf;
					index1 = i;
				}
				else if(leaf >= max2)
				{
					max2 = leaf;
					index2 = i;
				}
			}
		}

		return k == 1 ? (index1 + " " + fact[max1]) : (index2 + " " + fact[max2]);
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