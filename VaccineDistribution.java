import java.io.*;
import java.util.*;

class VaccineDistribution{

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int d = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");

		int risk = 0;
		int not = 0;
		int age;

		for(int i = 0; i < n; i++)
		{
			age = Integer.parseInt(st[i]);

			if(age <= 9 || age >= 80)
				risk++;
			else
				not++;
		}

		int days = risk/d + (risk % d != 0 ? 1 : 0) + not/d + (not % d != 0 ? 1 : 0);

		if(d == 1)
			days = n;

		System.out.println(days);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));

		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}