import java.io.*;
import java.util.*;

class ZebraCrossing{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		String s = br.readLine();

		int num = s.charAt(0) == '0' ? k % 2 : (k + 1) % 2;

		int last = -1;

		int i = n - 1;

		while(i >= 0 && last == -1)
		{
			if(s.charAt(i) - '0' == num)
			{
				last = i;
				break;
			}

			i--;
		}

		if(last == -1)
			return -1;

		num = (num + 1) % 2;

		while(i >= 0 && k > 0)
		{
			if(s.charAt(i) - '0' == num)
			{
				k--;
				num = (num + 1) % 2;
			}

			i--;
		}

		return k > 0 ? -1 : last + 1;
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