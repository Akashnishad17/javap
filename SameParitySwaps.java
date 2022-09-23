import java.io.*;
import java.util.*;

class SameParitySwaps{

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

			String s = next();

			int oddZeros = 0;
			int oddOnes = 0;
			int evenZeroes = 0;
			int evenOnes = 0;

			for(int i = 0; i < n; i++)
			{
				if(i % 2 == 0)
				{
					if(s.charAt(i) == '0')
						evenZeroes++;
					else
						evenOnes++;
				}
				else
				{
					if(s.charAt(i) == '0')
						oddZeros++;
					else
						oddOnes++;
				}
			}

			int max1 = fillArray1(n, oddZeros, oddOnes, evenZeroes, evenOnes);
			int max2 = fillArray2(n, oddZeros, oddOnes, evenZeroes, evenOnes);

			println(Math.max(max1, max2));
		}
	}

	private static int fillArray1(int n, int oddZeros, int oddOnes, int evenZeroes, int evenOnes)
	{
		int[] dp = new int[n];
		int count = 0;

		for(int i = 0; i < n; i++)
		{
			if(i % 2 == 0)
			{
				if(evenZeroes > 0)
					evenZeroes--;
				else
				{
					dp[i] = 1;
					evenOnes--;
				}
			}
			else
			{
				if(oddOnes > 0)
				{
					dp[i] = 1;
					oddOnes--;
				}
				else
					oddZeros--;
			}

			if(i - 1 >= 0 && dp[i-1] == 0 && dp[i] == 1)
				count++;
		}

		return count;
	}

	private static int fillArray2(int n, int oddZeros, int oddOnes, int evenZeroes, int evenOnes)
	{
		int[] dp = new int[n];
		int count = 0;

		for(int i = 0; i < n; i++)
		{
			if(i % 2 == 0)
			{
				if(evenOnes > 0)
				{
					dp[i] = 1;
					evenOnes--;
				}
				else
					evenZeroes--;
			}
			else
			{
				if(oddZeros > 0)
					oddZeros--;
				else
				{
					dp[i] = 1;
					oddOnes--;
				}
			}

			if(i - 1 >= 0 && dp[i-1] == 0 && dp[i] == 1)
				count++;
		}

		return count;
	}
}