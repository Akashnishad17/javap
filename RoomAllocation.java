import java.io.*;
import java.util.*;

class RoomAllocation{

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static String[] buffer;
	private static int index; 

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

	private static class Node{
		int val; // time
		int index; 
		int flag; // 0 - arrival, 1 - departure

		public Node(int val, int index, int flag)
		{
			this.val = val;
			this.index = index;
			this.flag = flag;
		}
	}

	private static void solve() throws Exception {
		int n = nextInt();

		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.val == b.val ? a.flag - b.flag : a.val - b.val);		

		for(int i = 0; i < n; i++)
		{
			int x = nextInt();
			int y = nextInt();

			pq.add(new Node(x, i, 0));
			pq.add(new Node(y, i, 1));
		}

		int count = 0;

		PriorityQueue<Integer> mex = new PriorityQueue<>();

		int[] dp = new int[n];

		while(pq.size() > 0)
		{
			Node node = pq.poll();

			if(node.flag == 0)
				dp[node.index] = mex.size() == 0 ? ++count : mex.poll();
			else
				mex.add(dp[node.index]);
		}

		println(count);

		for(int x : dp)
			print(x + " ");
	}
}