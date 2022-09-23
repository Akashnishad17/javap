import java.io.*;
import java.util.*;

public class DesktopRearrangement{

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
		int n = nextInt();
		int m = nextInt();
		int q = nextInt();

		int[][] grid = new int[m+1][n+1];

		for(int i = 1; i <= n; i++)
		{
			String s = next();

			for(int j = 1; j <= m; j++)
			{
				if(s.charAt(j-1) == '*')
					grid[j][i] = 1;
			}
		}

		int[][] seg = new int[m+1][4*n];

		for(int i = 1; i <= m; i++)
			build(seg[i], grid[i], 1, 1, n);

		int[] col = new int[m+1];

		for(int i = 1; i <= m; i++)
			col[i] = seg[i][1];

		int[] colseg = new int[4*m];

		build(colseg, col, 1, 1, m);

		while(q-- > 0)
		{
			int y = nextInt();
			int x = nextInt();

			int val = grid[x][y] == 0 ? 1 : 0;
			grid[x][y] = val;

			update(seg[x], 1, 1, n, y, val);
			colseg[x] = seg[x][1];

			update(colseg, 1, 1, m, x, seg[x][1]);

			int cells = x + (y - 1) * n;

			int count = 0;

			if(x > 1)
				count += sum(colseg, 1, 1, m, 1, x - 1);

			count += sum(seg[x], 1, 1, n, 1, y);

			println(cells - count);
		}
	}

	private static int sum(int[] seg, int index, int left, int right, int low, int high){
		if(right < low || high < left)
			return 0;

		if(low <= left && right <= high)
			return seg[index];

		int mid = left + (right - left) / 2;

		return sum(seg, 2 * index, left, mid, low, high)
			+ sum(seg, 2 * index + 1, mid + 1, right, low, high);
	}

	private static void update(int[] seg, int index, int left, int right, int in, int val){
		if(left == right){
			seg[index] = val;
			return;
		}

		int mid = left + (right - left) / 2;

		if(in <= mid)
			update(seg, 2 * index, left, mid, in, val);
		else
			update(seg, 2 * index + 1, mid + 1, right, in, val);

		seg[index] = seg[2 * index] + seg[2 * index + 1];
	}

	private static void build(int[] seg, int[] arr, int index, int left, int right){
		if(left == right)
		{
			seg[index] = arr[left];
			return;
		}

		int mid = left + (right - left) / 2;

		build(seg, arr, 2 * index, left, mid);
		build(seg, arr, 2 * index + 1, mid + 1, right);

		seg[index] = seg[2 * index] + seg[2 * index + 1];
	}
}