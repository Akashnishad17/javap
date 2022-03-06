import java.io.*;
import java.util.*;

class PencilBoxing{
	public static int solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		int n = s.length();

		int k = Integer.parseInt(br.readLine());

		int i = -1; // for box
		int j = -1; // for pencil

		for(int a = 0; a < n; a++)
		{
			if(i != -1 && j != -1)
				break;

			if(s.charAt(a) == 'B' && i == -1)
				i = a;
			if(s.charAt(a) == 'U' && j == -1)
				j = a;
		}

		if(i == -1 || j == -1)
			return 0;

		int count = 0;

		while(i < n && j < n)
		{
			if((int)Math.abs(i - j) <= k)
			{
				count++;
				i++;
				j++;
				while(i < n && s.charAt(i) != 'B')
					i++;
				while(j < n && s.charAt(j) != 'U')
					j++;
			}
			else
			{
				if(i < j)
				{
					i++;
					while(i < n && s.charAt(i) != 'B')
						i++;
				}
				else
				{
					j++;
					while(j < n && s.charAt(j) != 'U')
						j++;
				}
			}
		}

		return count;
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}