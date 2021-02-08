import java.io.*;
import java.util.*;

class GCDExtended{
	public static void solve(BufferedReader br) throws Exception
	{
		long a = Long.parseLong(br.readLine());
		long b = Long.parseLong(br.readLine());

		long r1 = a;
		long r2 = b;
		long s1 = 1, s2 = 0, t1 = 0, t2 = 1, s = -1, t = -1, r = -1, q;

		while(r2 > 0)
		{
			q = r1 / r2;
			r = r1 - r2*q;
			s = s1 - s2*q;
			t = t1 - t2*q;

			System.out.println(q+" "+r1+" "+r2+" "+r+" "+s1+" "+s2+" "+s+" "+t1+" "+t2+" "+t);

			r1 = r2;
			r2 = r;

			s1 = s2;
			s2 = s;

			t1 = t2;
			t2 = t;
		}

		r = r1;
		s = s1;
		t = t1;

		System.out.print(r+" "+s+" "+t);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}