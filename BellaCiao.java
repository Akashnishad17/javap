import java.io.*;
import java.util.*;

class BellaCiao{
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		long D = Long.parseLong(st[0]);
		long d = Long.parseLong(st[1]);
		long P = Long.parseLong(st[2]);
		long Q = Long.parseLong(st[3]);

		long x = D / d + (D % d == 0 ? 0 : 1);
		long res = (D % d == 0 ? d : D % d) * (P + (x - 1) * Q);

		if(x > 1)
			res += d * (P * (x - 1));

		if(x > 2)
			res += d * (Q * (((x - 1) * (x - 2))/2));

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