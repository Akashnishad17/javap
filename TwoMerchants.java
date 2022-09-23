import java.io.*;
import java.util.*;

class TwoMerchants{

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
			int m = nextInt();
			long c = nextLong();

			long[] a = new long[n];
			long[] b = new long[m];

			Stack<Long> fst1 = new Stack<>();
			Stack<Long> fst2 = new Stack<>();

			Stack<Long> bst1 = new Stack<>();
			Stack<Long> bst2 = new Stack<>();

			for(int i = 0; i < n; i++)
				a[i] = nextLong();

			for(int i = 0; i < m; i++)
				b[i] = nextLong();

			for(int i = 0; i < n && a[i] <= c; i++)
				fst1.add(a[i]);

			for(int i = n - 1; i >= 0 && a[i] > c; i--)
				bst1.add(a[i]);

			for(int i = 0; i < m && b[i] <= c; i++)
				fst2.add(b[i]);

			for(int i = m - 1; i >= 0 && b[i] > c; i--)
				bst2.add(b[i]);

			boolean flag = bst2.size() == 0 ? helper(fst2, bst2, fst1, bst1, 0, 0, c) : helper(fst1, bst1, fst2, bst2, 0, 0, c);

			println(flag ? "YES" : "NO");
		}
	}

	private static boolean helper(Stack<Long> fst1, Stack<Long> bst1, Stack<Long> fst2, Stack<Long> bst2, long a, long b, long c)
	{
		if(fst1.size() == 0 && fst2.size() == 0)
			return bst1.size() == 0 && bst2.size() == 0;

		if(bst1.size() == 0 && bst2.size() == 0)
			return true;

		if(bst2.size() == 0 && fst2.size() == 0)
			return false;

		while(fst1.size() > 0 && bst2.size() > 0)
		{
			fst1.pop();
			a++;
			b--;

			if(bst2.size() > 0)
			{
				long x = bst2.peek();

				if(x + b <= c)
					fst2.add(bst2.pop());
			}
		}

		return helper(fst2, bst2, fst1, bst1, b, a, c);
	}
}