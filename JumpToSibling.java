import java.io.*;
import java.util.*;

class JumpToSibling {

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

			int[] arr = new int[n];

			int ones = 0, zeroes = 0;

			for(int i = 0; i < n; i++)
			{
				arr[i] = nextInt() % 2;

				if(arr[i] == 1)
					ones++;
				else
					zeroes++;
			}

			if(arr[0] == arr[n-1])
				println(arr[0] == 1 ? ones - 1 : zeroes - 1);
			else
			{
				int min = n;

				int[] dp = new int[n];
				dp[0] = arr[0];

				for(int i = 1; i < n; i++)
					dp[i] += dp[i-1] + arr[i];

				boolean flag = arr[0] == 0;

				for(int i = 0; i < n - 1; i++)
				{
					if(flag)
					{
						if(arr[i] == 0)
						{
							int z = i + 1 - dp[i];
							int o = dp[n-1] - dp[i];

							min = Math.min(min, z + o - 1);
						}
					}
					else
					{
						if(arr[i] == 1)
						{
							int o = dp[i];
							int z = n - i - 1 - (dp[n-1] - dp[i]);

							min = Math.min(min, z + o - 1);
						}
					}
				}

				println(min);
			}
		}
	}
}