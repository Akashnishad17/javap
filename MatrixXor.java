import java.io.*;
import java.util.*;

class MatrixXor{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
		int k = Integer.parseInt(st[2]);

		if(n > m)
		{
			int temp = n;
			n = m;
			m = temp;
		}

		int res = 0;

		for(int i = 1; i <= n; i++)
			res ^= (i + i + k);

		for(int j = n + 1; j <= m; j += 2)
		{
			if(j == m)
			{
				for(int i = 1; i <= n; i++)
					res ^= (i + j + k);
			}
			else
			{
				res ^= (1 + j + k);
				res ^= (n + j + 1 + k);
			}
		}

		return res;
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