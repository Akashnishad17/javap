import java.io.*;
import java.util.*;

class ChefAndMeetings{

	public static int inMinutes(String hr, String min, String mer)
	{
		int total = Integer.parseInt(min);

		if(mer.equals("PM"))
			total += 12 * 60;

		int h = Integer.parseInt(hr);

		if(h != 12)
			total += h * 60;

		return total;
	}

	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" |:");

		int p = inMinutes(st[0], st[1], st[2]);

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(n-- > 0)
		{
			st = br.readLine().split(" |:");

			int l = inMinutes(st[0], st[1], st[2]);
			int r = inMinutes(st[3], st[4], st[5]);

			if(l <= p && p <= r)
				sb.append('1');
			else
				sb.append('0');
		}

		return sb.toString();
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