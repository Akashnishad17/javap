import java.io.*;
import java.util.*;

class HalfSequence{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		List<Integer> list = new ArrayList<>();

		boolean flag = false;

		for(String s : st)
		{
			int num = Integer.parseInt(s);

			if(num % 2 == 0)
			{
				if(num % 4 != 0)
					flag = true;

				while(num % 2 == 0)
					num /= 2;

				list.add(num);
			}
		}

		if(!flag)
			return "NO";

		if((n + 1)/2 > list.size())
			return "NO";

		return "YES";
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