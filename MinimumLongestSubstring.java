import java.io.*;
import java.util.*;

class MinimumLongestSubstring{

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
		int tc = nextInt();

		while(tc-- > 0)
		{
			int n = nextInt();
			String a = next();

			int zeroes = 0, ones = 0;

			for(int i = 0; i < n; i++)
			{
				if(a.charAt(i) == '0')
					zeroes++;
				else
					ones++;
			}

			String s = null;
			String t = null;

			if(ones >= zeroes)
			{
				s = generateStringS(ones, zeroes, 0);
				t = generateStringT(ones, zeroes, 0);
			}
			else
			{
				s = generateStringS(zeroes, ones, 1);
				t = generateStringT(zeroes, ones, 1);
			}

			println(s);
			println(t);
		}
	}

	private static String generateStringT(int a, int b, int parity){
		int seg = 0;

		if(a > b)
		{
			if(a % (b + 1) == 0)
				seg = a / (b + 1);
			else
				seg = 1 + (a / (b + 1));
		}
		else if(b != 0)
			seg = a / b;

		StringBuilder sb = new StringBuilder();

		while(a > 0 && b > 0)
		{
			int temp = seg;

			while(temp > 0 && a > 0)
			{
				sb.insert(0, parity == 0 ? 1 : 0);
				temp--;
				a--;
			}

			if(b > 0)
			{
				sb.insert(0, parity == 0 ? 0 : 1);
				b--;
			}	

			if(a > b)
			{
				if(a % (b + 1) == 0)
					seg = a / (b + 1);
				else
					seg = 1 + (a / (b + 1));
			}
			else if(b != 0)
				seg = a / b;

		}

		while(a > 0)
		{
			sb.insert(0, parity == 0 ? 1 : 0);
			a--;
		}

		if(b > 0)
		{
			sb.insert(0, parity == 0 ? 0 : 1);
			b--;
		}

		return sb.toString();
	}

	private static String generateStringS(int a, int b, int parity){
		StringBuilder sb = new StringBuilder();

		while(a-- > 0)
			sb.append(parity == 0 ? 1 : 0);
		
		while(b-- > 0)
			sb.append(parity == 0 ? 0 : 1);

		return sb.toString();
	}
}