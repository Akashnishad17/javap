import java.io.*;
import java.util.*;

class DragonadoAndXOR{

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
		int t = nextInt();

		while(t-- > 0){
			int n = nextInt();

			int[] arr = new int[n];

			for(int i = 0; i < n; i++)
				arr[i] = nextInt();

			if(n >= 70)
				findSolution(arr, n);
			else
				bruteSolution(arr, n);
		}
	}

	private static void findSolution(int[] arr, int n) throws Exception {
		int[] dp = new int[32];

		Arrays.fill(dp, -1);

		for(int i = 0; i < n - 1; i += 2)
		{
			int count = popcount(arr[i] ^ arr[i + 1]);
			if(dp[count] != -1)
			{
				println((dp[count] + 1) + " " + (dp[count] + 2) + " " + (i + 1) + " " + (i + 2));
				return;
			}

			dp[count] = i;
		}
	}

	private static void bruteSolution(int[] arr, int n) throws Exception{
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n && j != i; j++)
			{
				for(int k = 0; k < n && k != i && k != j; k++)
				{
					for(int l = 0; l < n && l != i && l != j && l != k; l++)
					{
						if(popcount(arr[i] ^ arr[j]) == popcount(arr[k] ^ arr[l])) {
							println((i + 1) + " " + (j + 1) + " " + (k + 1) + " " + (l + 1));
							return;
						}
					}
				}
			}
		}

		println(-1);
	}

	private static int popcount(int n)
	{
		return Integer.bitCount(n);
	}
}