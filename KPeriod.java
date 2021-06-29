import java.io.*;
import java.util.*;

class KPeriod{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		char[] ch = br.readLine().toCharArray();

		for(int i = 0; i < k; i++)
		{
			char c = '.';

			for(int j = i; j < n; j += k)
			{
				if(ch[j] != '?')
				{
					if(c == '.')
						c = ch[j];
					else if(c != ch[j])
						return "-1";
				}
			}

			if(c == '.')
				c = 'a';

			for(int j = i; j < n; j += k)
				ch[j] = c;
		}

		return new String(ch);
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