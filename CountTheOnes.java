import java.io.*;
import java.util.*;

class CountTheOnes{

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static String[] buffer;
	private static int index; 

	private static void before() throws Exception {
		//online();
		local();
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
		long[] pow = new long[51];
		long[] count = new long[51];

		pow[0] = 1;

		for(int i = 1; i <= 50; i++)
		{
			pow[i] = 2 * pow[i-1];
			count[i] = pow[i-1] * i;
		}

		int t = nextInt();

		while(t-- > 0)
		{
			int n = nextInt();
			long k = nextLong();

			println(dfs(n, k, 1, 1, pow[n] - 1, pow, count));
		}
	}

	private static long dfs(int n, long k, long val, long left, long right, long[] pow, long[] count) throws Exception{
		if(left == k)
			return val;

		if(right <= k)
			return count[n]  + (val - 1) * (right - left + 1);

		long mid = (right + left) / 2;

		if(mid < k)
			return val + dfs(n-1, k, val, left + 1, mid, pow, count) + dfs(n - 1, k, val + 1, mid + 1, right, pow, count);
		else
			return val + dfs(n-1, k, val, left + 1, mid, pow, count);
	}
}