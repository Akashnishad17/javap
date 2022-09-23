import java.io.*;
import java.util.*;

class MinimumColoring {

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
			int m = nextInt();

			int[][] arr = new int[n+1][m+1];

			int x1 = nextInt();
			int y1 = nextInt();

			int x2 = nextInt();
			int y2 = nextInt();

			int diff = (int)Math.abs(x1 - x2) + (int)Math.abs(y1 - y2);

			if(diff % 2 == 1)
			{
				for(int i = 1; i <= n; i++)
				{
					for(int j = 1; j <= m; j++)
					{
						if((i + j) % 2 == (x1 + y1) % 2)
							arr[i][j] = 1;
						else
							arr[i][j] = 2;
					}
				}
			}
			else
			{
				if(x1 != x2)
				{
					for(int i = 1; i <= n; i++)
					{
						for(int j = 1; j <= m; j++)
						{
							if(x1 < x2)
							{
								if(i <= x1)
								{
									if((i + j) % 2 == (x1 + y1) % 2)
										arr[i][j] = 1;
									else
										arr[i][j] = i == x1 ? 3 : 2;
								}
								else
								{
									if((i + j) % 2 == (x2 + y2) % 2)
										arr[i][j] = 2;
									else
										arr[i][j] = (i == x1 + 1) ? 3 : 1;
								}
							}
							else
							{
								if(i <= x2)
								{
									if((i + j) % 2 == (x2 + y2) % 2)
										arr[i][j] = 2;
									else
										arr[i][j] = i == x2 ? 3 : 1;
								}
								else
								{
									if((i + j) % 2 == (x1 + y1) % 2)
										arr[i][j] = 1;
									else
										arr[i][j] = (i == x2 + 1) ? 3 : 2;
								}
							}
						}
					}
				}
				else
				{
					for(int j = 1; j <= m; j++)
					{
						for(int i = 1; i <= n; i++)
						{
							if(y1 < y2)
							{
								if(j <= y1)
								{
									if((i + j) % 2 == (x1 + y1) % 2)
										arr[i][j] = 1;
									else
										arr[i][j] = j == y1 ? 3 : 2;
								}
								else
								{
									if((i + j) % 2 == (x2 + y2) % 2)
										arr[i][j] = 2;
									else
										arr[i][j] = (j == y1 + 1) ? 3 : 1;
								}
							}
							else
							{
								if(j <= y2)
								{
									if((i + j) % 2 == (x2 + y2) % 2)
										arr[i][j] = 2;
									else
										arr[i][j] = j == y2 ? 3 : 1;
								}
								else
								{
									if((i + j) % 2 == (x1 + y1) % 2)
										arr[i][j] = 1;
									else
										arr[i][j] = (j == y2 + 1) ? 3 : 2;
								}
							}
						}
					}
				}
			}

			for(int i = 1; i <= n; i++)
			{
				for(int j = 1; j <= m; j++)
					print(arr[i][j] + " ");

				println();
			}
		}
	}
}