import java.io.*;
import java.util.*;

class MaximumSubarray{

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

			long[] a = new long[n + 2];

			for(int i = 0; i < n; i++)
				a[i + 1] = nextLong();

			int m = nextInt();

			long[] b = new long[m];

			for(int i = 0; i < m; i++)
				b[i] = nextLong();

			long minNeg = Long.MIN_VALUE;
			long posSum = 0;

			for(int i = 0; i < m; i++)
			{
				if(b[i] > 0)
					posSum += b[i];
				else
					minNeg = Math.max(minNeg, b[i]);
			}

			if(posSum == 0)
				posSum = minNeg;

			a[0] = posSum; 
			a[n+1] = posSum;

			long max1 = maxSum(a, 0, n);
			long max2 = maxSum(a, 1, n + 1);

			println(Math.max(max1, max2));
		}
	}

	private static long maxSum(long[] arr, int l, int r){
		long max = Long.MIN_VALUE;
		long sum = 0;

		for(int i = l; i <= r; i++)
		{
			sum += arr[i];

			if(sum > max)
				max = sum;

			if(sum < 0)
				sum = 0;
		}

		return max;
	}
}