import java.io.*;
import java.util.*;

class MaxBITSum{

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static String[] buffer;
	private static int index; 

	private static void before() throws Exception {
		try{
			new BufferedReader(new FileReader("local.txt"));
			local();
		}catch(Exception e){
			online();
		}

		buffer = new String[0];
		index = 0;
	}

	private static void after() throws Exception {
		br.close();
		bw.close();
	}

	private static void online() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	private static void local() throws Exception {
		br = new BufferedReader(new FileReader("input.txt"));
		bw = new BufferedWriter(new FileWriter("output.txt"));
	}

	private static String next() throws Exception {
		if(buffer.length == index)
		{
			buffer = br.readLine().split(" ");
			index = 0;
		}

		return buffer[index++];
	}

	private static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	private static long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	private static double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	private static float nextFloat() throws Exception {
		return Float.parseFloat(next());
	}

	private static boolean nextBoolean() throws Exception {
		return Boolean.parseBoolean(next());
	}

	private static void print(int x) throws Exception {
		bw.write(x + "");
	}

	private static void println(int x) throws Exception {
		bw.write(x + "\n");
	}

	private static void print(long x) throws Exception {
		bw.write(x + "");
	}

	private static void println(long x) throws Exception {
		bw.write(x + "\n");
	}

	private static void print(boolean x) throws Exception {
		bw.write(x + "");
	}

	private static void println(boolean x) throws Exception {
		bw.write(x + "\n");
	}

	private static void print(char x) throws Exception {
		bw.write(x);
	}

	private static void println(char x) throws Exception {
		bw.write(x + "\n");
	}

	private static void print(float x) throws Exception {
		bw.write(x + "");
	}

	private static void println(float x) throws Exception {
		bw.write(x + "\n");
	}

	private static void print(double x) throws Exception {
		bw.write(x + "");
	}

	private static void println(double x) throws Exception {
		bw.write(x + "\n");
	}

	private static void print(String x) throws Exception {
		bw.write(x);
	}

	private static void println(String x) throws Exception {
		bw.write(x + "\n");
	}

	private static void println() throws Exception {
		bw.write("\n");
	}

	public static void main(String[] args) throws Exception {
		before();		
		solve();
		after();
	}

	private static void solve() throws Exception {
		int t = nextInt();

		while(t-- > 0)
		{
			int n = nextInt();

			int[] a = new int[n];
			int[] b = new int[n];

			for(int i = 0; i < n; i++)
				a[i] = nextInt();

			for(int i = 0; i < n; i++)
				b[i] = nextInt();

			int[][] bits = new int[21][2]; // 0 -> ones, 1 -> zeroes

			int[][][] highs = new int[21][21][2];

			for(int i = 0; i < n; i++)
			{
				int bit = highBit(a[i]);

				for(int j = 0; j <= 20; j++)
				{
					if((a[i] & (1 << j)) > 0)
					{
						bits[j][0]++;
						highs[bit][j][0]++;
					}
					else
					{
						bits[j][1]++;
						highs[bit][j][1]++;
					}
				}
			}

			long sum = 0;

			for(int i = 0; i < n; i++)
			{
				int bit = highBit(b[i]);

				for(int j = 0; j <= 20; j++)
				{
					int ones = highs[bit][j][0];
					int zeroes = highs[bit][j][1];

					int onesR = bits[j][0] - ones;
					int zeroesR = bits[j][1] - zeroes;

					if((b[i] & (1 << j)) > 0)
					{
						sum += (1L << j) * ones;
						sum += (1L << j) * zeroesR;
					}
					else
					{
						sum += (1L << j) * onesR;
					}
				}
			}

			println(sum);
		}
	}

	private static int highBit(int n)
	{
		int count = 0;

		while(n  > 0)
		{
			n /= 2;
			count++;
		}

		return count;
	}
}