import java.io.*;
import java.util.*;

public class WaterTheTrees{

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

			int max = 0;

			for(int i = 0; i < n; i++)
			{
				arr[i] = nextInt();
				max = Math.max(max, arr[i]);
			}

			long c1 = 0, c2 = 0;

			long res = 0;

			for(int i = 0; i < n; i++)
			{
				int x = max - arr[i];

				if(x != 0)
				{
					int temp = x / 3;
					res += temp * 2;

					if(x % 3 == 1)
						c1++;
					else if(x % 3 == 2)
						c2++;
				}
			}

			res += c2 - (c2 % 3);
			c2 %= 3;

			boolean flag = true;

			if(c1 == 0)
			{
				if(c2 == 1)
					res += 2;
				else if(c2 == 2)
					res += 3;

				c2 = 0;
			}
			else
			{
				if(c2 == 1)
				{
					res += 2;
					c1--;
				}
				else if(c2 == 2)
				{
					res += 3;
					flag = false;
				}
				
				c2 = 0;
			}

			if(c1 > 0)
			{
				res += c1 * 2;
				if(flag)
					res--;
			}

			println(res);
		}	
	}
}