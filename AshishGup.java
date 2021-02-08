import java.io.*;
import java.util.*;

class AshishGup{
	public static String solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");

		int x;
		int solved = 0;
		boolean onesec = true, kcross = false; 

		for(int i = 0; i < n; i++)
		{
			x = Integer.parseInt(st[i]);

			if(x == -1)
				continue;

			solved++;

			if(x > 1)
				onesec = false;

			if(x > k)
				kcross = true;
		}

		boolean rejected = false;

		if(n % 2 == 0)
		{
			if(solved < n/2)
				rejected = true;
		}
		else
		{
			if(solved < n/2 + 1)
				rejected = true;
		}


		if(rejected)
			return "Rejected";

		if(kcross)
			return "Too Slow";

		if(onesec && solved == n)
			return "Bot";

		return "Accepted";


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