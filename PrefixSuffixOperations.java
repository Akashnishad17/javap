import java.io.*;
import java.util.*;

class PrefixSuffixOperations{

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

		while(t-- > 0)
		{
			int n = nextInt();

			long[] arr = new long[n];

			for(int i = 0; i < n; i++)
				arr[i] = nextLong();

			for(int i = 0; i < n; i++)
				arr[i] = nextLong() - arr[i];

			boolean valid = true;

			int l = -1, r = -1;

			int index = -1;

			for(int i = 0; i < n; i++)
			{
				if(arr[i] < 0)
				{
					valid = false;
					break;
				}
				
				if(arr[i] == 0)
				{
					if(l == -1)
					{
						l = i;
						r = i;
					}
					else
					{
						if(index != -1 && l <= index && index <= i)
						{
							valid = false;
							break;
						}
						r = i;
					}
				}
				else
					index = i;
			}

			if(!valid)
				println(-1);
			else
			{
				if(l == -1)
				{
					long max = arr[0];

					boolean down = false;

					for(int i = 1; i < n; i++)
					{
						max = Math.max(arr[i], max);

						if(arr[i-1] > arr[i])
							down = true;
						
						if(down && arr[i-1] < arr[i])
						{
							valid = false;
							break;
						}
					}

					if(max > arr[0] + arr[n-1])
						valid = false;

					if(valid)
						println(max);
					else
						println(-1);

				}
				else
				{
					long left = l - 1 >= 0 ? arr[l - 1] : 0;
					long right = r + 1 < n ? arr[r + 1] : 0;

					for(int i = 1; i < l; i++)
					{
						if(arr[i-1] != arr[i])
						{
							valid = false;
							break;
						}
					}

					for(int i = r + 2; i < n; i++)
					{
						if(arr[i-1] != arr[i])
						{
							valid = false;
							break;
						}
					}

					if(valid)
						println(left + right);
					else
						println(-1);
				}
			}
		}
	}
}