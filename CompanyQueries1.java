import java.io.*;
import java.util.*;

class CompanyQueries1{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int[] tree = new int[n+1];

		for(int i = 2; i <= n; i++)
			tree[i] = Integer.parseInt(st[i-2]);

		int x, k;

		StringBuilder sb = new StringBuilder();

		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			x = Integer.parseInt(st[0]);
			k = Integer.parseInt(st[1]);

			while(k-- > 0 && x > 0)
				x = tree[x];

			if(x == 0)
				x = -1;

			sb.append(x+"\n");
		}

		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		while(t-- > 0)
			solve(br);
	}
}