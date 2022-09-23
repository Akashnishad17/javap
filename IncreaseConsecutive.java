import java.io.*;
import java.util.*;

class IncreaseConsecutive{

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
			int q = nextInt();

			String a = next();
			String b = next();

			int[] dp1 = new int[n+1];
			int[] dp2 = new int[n+1];

			for(int i = 1; i <= n; i++)
			{
				if(a.charAt(i - 1) != 'a')
					dp1[i] = 26 - (a.charAt(i - 1) - 'a');
				if(b.charAt(i - 1) != 'a')
					dp2[i] = 26 - (b.charAt(i - 1) - 'a');

				if(dp1[i-1] <= dp1[i])
					dp1[i] -= dp1[i-1];
				else
					dp1[i] = 26 - (dp1[i-1] - dp1[i]);

				if(dp2[i-1] <= dp2[i])
					dp2[i] -= dp2[i-1];
				else
					dp2[i] = 26 - (dp2[i-1] - dp2[i]);
			}

			while(q-- > 0)
			{
				int l = nextInt();
				int r = nextInt();

				if(l == r)
					println(a.charAt(l-1) == b.charAt(r-1) ? "Yes" : "No");
				else
				{
					int x = (dp1[r - 1] - dp1[l-1] + 26) % 26;
					int y = (dp2[r - 1] - dp2[l-1] + 26) % 26;

					println(x + " " + y);

					if((x + (a.charAt(r - 1) - 'a')) % 26 == (y + (b.charAt(r - 1) - 'a')) % 26)
						println("Yes");
					else
						println("No");
				}
			}
		}
	}
}