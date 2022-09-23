import java.io.*;
import java.util.*;

public class MaximumProductStrikesBack{

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

			for(int i = 0; i < n; i++)
				arr[i] = nextInt();

			int last = -1;

			int x = 0, y = n;

			int max = 0;

			for(int i = 0; i < n; i++)
			{
				if(arr[i] == 0)
				{
					if(last + 1 <= i - 1)
					{
						int[] a = check(arr, last + 1, i - 1, n);
						if(a[0] > max)
						{
							max = a[0];
							x = a[1];
							y = a[2];
						}
					}
					last = i;
				}
			}

			if(last + 1 <= n - 1)
			{
				int[] a = check(arr, last + 1, n - 1, n);
				if(a[0] > max)
				{
					max = a[0];
					x = a[1];
					y = a[2];
				}
			}

			println(x + " " + y);
		}
	}

	private static int[] check(int[] arr, int l, int r, int n) throws Exception
	{
		int count = 0;
		int neg = 0;

		for(int i = l; i <= r; i++)
		{
			if(arr[i] % 2 == 0)
				count++;

			if(arr[i] < 0)
				neg++;
		}

		if(neg % 2 == 0)
			return new int[]{count, l, n - r - 1};

		int index1 = l;
		int dec1 = 0;

		while(index1 <= r)
		{
			if(arr[index1] % 2 == 0)
				dec1++;

			if(arr[index1] < 0)
				break;

			index1++;
		}

		int index2 = r;
		int dec2 = 0;

		while(index2 >= l)
		{
			if(arr[index2] % 2 == 0)
				dec2++;

			if(arr[index2] < 0)
				break;

			index2--;
		}

		if(index1 < r && index2 > l)
		{
			if(dec1 < dec2)
				return new int[]{count - dec1, index1 + 1, n - r - 1};
			else
				return new int[]{count - dec2, l, n - index2};
		}
		else if(index1 < r)
			return new int[]{count - dec1, index1 + 1, n - r - 1};
		else if(index2 > l)
			return new int[]{count - dec2, l, n - index2};

		return new int[]{1, 0, n};
	}
}