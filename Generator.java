import java.io.*;
import java.util.*;

class Generator{

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
		int n = nextInt();

		List<String> list = new ArrayList<>();

		for(int i = 1; i < Math.pow(2, n); i++)
			list.add(convertToBinary(i));
		
		Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(final String a, final String b){
				for(int i = 0; i < Math.min(a.length(), b.length()); i++){
					if(a.charAt(i) > b.charAt(i))
						return 1;
					if(a.charAt(i) < b.charAt(i))
						return -1;
				}

				return a.length() - b.length();
			}
		});

		for(int i = 0; i < Math.pow(2, n) - 1; i++){
			println(countOne(list.get(i)) + " " + list.get(i));
		}
	}

	private static int countOne(String s){
		int count = 0;

		for(int i = 0; i < s.length(); i++)
			count += s.charAt(i) - '0';

		return count++;
	}

	private static String convertToBinary(int n)
	{
		String s = "";

		while(n > 0)
		{
			s = n % 2 + s;
			n /= 2;
		}

		return s;
	}
}