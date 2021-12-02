import java.io.*;
import java.util.*;

class XorKiMaaKiAnkh{

	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int a = Integer.parseInt(st[0]);
		int b = Integer.parseInt(st[1]);
		int c = Integer.parseInt(st[2]);
		int d = Integer.parseInt(st[3]);

		long[] setA = setBits(a);
		long[] setB = setBits(b+1);
		long[] setC = setBits(c);
		long[] setD = setBits(d+1);

		long sum = 0;
		int mod = 1000000007;

		for(int i = 0; i < 31; i++)
		{
			long set1 = setB[i] - setA[i];
			long notSet1 = b - a + 1 - set1;

			long set2 = setD[i] - setC[i];
			long notSet2 = d - c + 1 - set2;

			sum = (sum + ((1 << i) * set1 * notSet2) % mod) % mod;
			sum = (sum + ((1 << i) * set2 * notSet1) % mod) % mod;
		}

		return sum;
	}

	public static long[] setBits(int x)
	{
		if(x == 0)
			return new long[31];

		long[] set = new long[31];

		long pow;

		for(int i = 0; i < 31; i++)
		{
			pow = 1 << i;
			set[i] = (x / (pow*2)) * pow;

			if(x % (pow*2) != 0 && x % (pow*2) > pow)
				set[i] += x % (pow*2) - pow;
		}

		return set;
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