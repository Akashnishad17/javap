import java.io.*;
import java.util.*;

class AlternativeSufferings{

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
			int k = nextInt();

			String s = next();

			int[] arr = new int[n];

			for(int i = 0; i < n; i++)
				arr[i] = s.charAt(i) - '0';

			for(int i = 0; i < n; i++)
			{
				if(arr[i] == 1)
					arr[i] = 3;
				else if(arr[i] == 0)
				{
					if(i - 1 >= 0 && (arr[i - 1] == 3))
						arr[i] = 1;
					else if(i + 1 < n && (arr[i + 1] == 1))
						arr[i] = 1;
				}
			}

			for(int i = 0; i < n; i++)
			{
				if(arr[i] == 3)
					arr[i] = 0;
			}

			k--;

			int[] prefix = new int[n];
			int[] suffix = new int[n];

			Arrays.fill(prefix, -1);
			Arrays.fill(suffix, -1);

			for(int i = 0; i < n; i++)
			{
				if(arr[i] == 1)
					prefix[i] = 0;
				else if(i - 1 >= 0 && prefix[i - 1] != -1)
					prefix[i] = prefix[i - 1] + 1;
			}

			for(int i = n - 1; i >= 0; i--)
			{
				if(arr[i] == 1)
					suffix[i] = 0;
				else if(i + 1 < n && suffix[i + 1] != -1)
					suffix[i] = suffix[i + 1] + 1;
			}

			int[] dp = new int[n];

			for(int i = 0; i < n; i++)
			{
				if(prefix[i] != -1 && suffix[i] != -1)
					dp[i] = Math.min(prefix[i], suffix[i]);
				else if(prefix[i] != -1)
					dp[i] = prefix[i];
				else
					dp[i] = suffix[i];
			}

			for(int i = 0; i < n; i++)
			{
				if(arr[i] == 1 && k % 2 == 1)
					arr[i] = 0;
				else if(dp[i] != -1 && arr[i] == 0 && k >= dp[i] && (k - dp[i]) % 2 == 0)
					arr[i] = 1;
			}

			for(int x : arr)
				print(x);

			println();
		}
	}
}