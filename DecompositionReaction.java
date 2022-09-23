import java.io.*;
import java.util.*;

class DecompositionReaction{

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static String[] buffer;
	private static int index; 

	private static int mod = 1000000007;

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

	private static class Node{
		int index;
		int parent;
		List<int[]> child = new ArrayList<>();

		public Node(int index){
			this.index = index;
			parent = 0;
			child = new ArrayList<>();
		}
	}

	private static void solve() throws Exception {
		int n = nextInt();
		int m = nextInt();

		long[] arr = new long[n+1];

		for(int i = 1; i <= n; i++)
			arr[i] = nextLong();

		HashMap<Integer, Node> map = new HashMap<>();

		while(m-- > 0)
		{
			int c = nextInt();
			int x = nextInt();

			Node node = map.getOrDefault(c, new Node(c));

			while(x-- > 0)
			{
				int w = nextInt();
				int ci = nextInt();

				node.child.add(new int[]{w, ci});

				Node child = map.getOrDefault(ci, new Node(ci));
				child.parent++;

				map.put(ci, child);
			}

			map.put(c, node);
		}



		Queue<Node> queue = new LinkedList<>();

		for(Node node : map.values())
		{
			if(node.parent == 0 && node.child.size() > 0)
				queue.add(node);
		}

		while(queue.size() > 0)
		{
			Node node = queue.poll();

			for(int[] c : node.child)
			{
				arr[c[1]] = (arr[c[1]] + (arr[node.index] * c[0]) % mod) % mod;

				Node child = map.getOrDefault(c[1], new Node(c[1]));

				if(child.parent != 0)
					child.parent--;

				map.put(c[1], child);

				if(child.parent == 0 && child.child.size() > 0)
					queue.add(child);
			}

			arr[node.index] = 0;
		}

		for(int i = 1; i <= n; i++)
			println(arr[i]);
	}
}