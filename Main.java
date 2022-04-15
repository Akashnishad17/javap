import java.io.*;
import java.util.*;

public class Main{

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static String[] buffer;
	private static int index;

	private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

	private static int mod = 1000000007;

	private static void before() throws Exception {
		online();
		//local();
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

			String[] arr = new String[n];

			for(int i = 0; i < n; i++)
				arr[i] = next();

			boolean[][] visited = new boolean[n][m];

			boolean processed = true;

			for(int i = 0; i < n && processed; i++)
			{
				for(int j = 0; j < m && processed; j++)
				{
					if(arr[i].charAt(j) == '1' && !visited[i][j])
					{
						visited[i][j] = true;
						int[] pos = dfs(arr, visited, i, j, n, m);

						processed = valid(arr, pos);
					}
				}
			}

			println(processed ? "YES" : "NO");
		}
	}

	private static boolean valid(String[] arr, int[] pos)
	{
		for(int i = pos[0]; i <= pos[1]; i++)
		{
			for(int j = pos[2]; j <= pos[3]; j++)
			{
				if(arr[i].charAt(j) == '0')
					return false;
			}
		}

		return true;
	}

	private static int[] dfs(String[] arr, boolean[][] visited, int i, int j, int n, int m) throws Exception
	{
		int[] pos = new int[]{-1, -1, -1, -1};

		for(int[] d : dir)
		{
			int x = i + d[0];
			int y = j + d[1];

			if(x >= 0 && x < n && y >= 0 && y < m && arr[x].charAt(y) == '1' && !visited[x][y])
			{
				visited[x][y] = true;
				int[] temp = dfs(arr, visited, x, y, n, m);

				if(pos[0] == -1)
					pos = temp;
				else
				{
					pos[0] = Math.min(pos[0], temp[0]);
					pos[1] = Math.max(pos[1], temp[1]);

					pos[2] = Math.min(pos[2], temp[2]);
					pos[3] = Math.max(pos[3], temp[3]);
				}
			}
		}

		if(pos[0] == -1)
			return new int[]{i, i, j, j};

		return pos;
	}
}