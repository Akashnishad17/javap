import java.io.*;
import java.util.*;

class FrogSort{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int[] weight = new int[n];
		int[] pos = new int[n];
		int[] l = new int[n];

		String[] st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
		{
			weight[i] = Integer.parseInt(st[i]);
			pos[weight[i]-1] = i;
		}

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			l[weight[i]-1] = Integer.parseInt(st[i]);

		int count = 0;

		for(int i = 1; i < n; i++)
		{
			if(pos[i-1] >= pos[i])
			{
				int left = pos[i-1] - pos[i] + 1;

				if(left % l[i] == 0)
				{
					count += left/l[i];
					pos[i] += left;
				}
				else
				{
					count += left/l[i] + 1;
					pos[i] += (left/l[i] + 1) * l[i];
				}
			}
		}

		return count; 
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