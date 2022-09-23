import java.io.*;
import java.util.*;

class MissingNumbers{

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

	private static long[] res;

	private static void solve() throws Exception {
		int t = nextInt();

		while(t-- > 0)
		{
			res = new long[]{-1, -1};

			long[] arr = new long[4];

			for(int i = 0; i < 4; i++)
				arr[i] = nextLong();

			permute(arr, 0, 3);

			println(res[0] + " " + res[1]);
		}
	}

	private static void permute(long[] arr, int l, int r)
	{
		if(res[0] != -1)
			return;

		if(l == r)
			findSolution(arr);
		else
		{
			for(int i = l; i <= r; i++)
			{
				swap(arr, l, i);
				permute(arr, l + 1, r);
				swap(arr, l, i);
			}
		}
	}

	private static void swap(long[] arr, int l, int r){
		long temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

	private static void findSolution(long[] arr)
	{
		long a = arr[0];
		long b = arr[1];
		long c = arr[2];
		long d = arr[3];

		if((a + b) % 2 == 1 || (a - b) % 2 == 1)
			return;

		long x = (a + b) / 2;
		long y = (a - b) / 2;

		if(x >= 1 && x <= 10000 && y >= 1 && y <= 10000)
		{
			if(x * y == c && x / y == d)
			{
				res[0] = x;
				res[1] = y;
			}
		}
	}
}