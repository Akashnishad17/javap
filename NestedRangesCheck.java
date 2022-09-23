import java.io.*;
import java.util.*;

class NestedRangesCheck{

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
		int n = nextInt();

		int[][] arr = new int[n][3];

		for(int i = 0; i < n; i++)
		{
			arr[i][0] = i;
			arr[i][1] = nextInt();
			arr[i][2] = nextInt();
		}

		Arrays.sort(arr, (a, b) -> a[1] == b[1] ? b[2] - a[2] : a[1] - b[1]);

		int[][] dp = new int[n][2];

		int min = Integer.MAX_VALUE;

		for(int i = n - 1; i >= 0; i--)
		{
			if(arr[i][2] >= min)
				dp[arr[i][0]][0] = 1;
			min = Math.min(min, arr[i][2]);
		}

		int max = Integer.MIN_VALUE;

		for(int i = 0; i < n; i++)
		{
			if(arr[i][2] <= max)
				dp[arr[i][0]][1] = 1;
			max = Math.max(max, arr[i][2]);
		}

		for(int i = 0; i < n; i++)
			print(dp[i][0] + " ");

		println();

		for(int i = 0; i < n; i++)
			print(dp[i][1] + " ");
	}
}