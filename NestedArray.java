import java.io.*;
import java.util.*;

//Input: [1, [2]], Output: [1, 2]
//Input: [1, [2, 3], [[4]]], Output: [1, 2, 3, 4]
// [1, [2, 3, 9], [[4]], [1]]

class NestedArray{

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

	private static String nextLine() throws Exception {
		return br.readLine();
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
		List<Object> input = new ArrayList<>();

		int n = nextInt();
		
		for(int i = 0; i < n; i++){
			String s = nextLine();
			String[] st = s.split(" ");
			if(st.length == 0){
				input.add(Integer.parseInt(st[0]));
			}
			else{
				List<Object> in = new ArrayList<>();

				for(String c : st){
					in.add(Integer.parseInt(c));
				}

				input.add(in);
			}
		}

		List<Integer> output = new ArrayList<>();

		flattener(input, output);

		for(int x : output)
			println(x);
	}

	private static void flattener(List<Object> input, List<Integer> output) throws Exception{
		for(int i = 0; i < input.size(); i++)
		{
			Object object = input.get(i);

			try
			{
				output.add((Integer)object);
			}catch(Exception e){
				List<Object> nestedInput = (List)object;
				flattener(nestedInput, output);
			}
		}
	}
}