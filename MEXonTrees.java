import java.io.*;
import java.util.*;

class MEXonTrees{

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
		int val;
		List<Integer> child;

		public Node(int index, int val)
		{
			this.index = index;
			this.val = val;
			child = new ArrayList<>();
		}
	}

	private static void solve() throws Exception {	
		int t = nextInt();

		while(t-- > 0)
		{
			int n = nextInt();

			Node[] map = new Node[n+1];

			for(int i = 1; i <= n; i++)
				map[i] = new Node(i, nextInt());


			for(int i = 1; i < n; i++)
			{
				int x = nextInt();
				int y = nextInt();

				map[x].child.add(y);
				map[y].child.add(x);
			}

			TreeSet<Integer> mex = new TreeSet<>();

			for(int i = 0; i <= n + 1; i++)
				mex.add(i);

			int[] path = new int[n+1];
			boolean[] visited = new boolean[n+1];

			visited[1] = true;
			mex.remove(map[1].val);
			path[map[1].val]++;

			println(dfs(1, map, path, mex, visited));
		}
	}

	private static int dfs(int index, Node[] map, int[] path, TreeSet<Integer> mex, boolean[] visited){
		int max = mex.first();

		Node node = map[index];

		for(int child : node.child)
		{
			if(!visited[child])
			{
				visited[child] = true;
				Node next = map[child];

				if(mex.contains(next.val))
					mex.remove(next.val);

				path[next.val]++;

				max = Math.max(max, dfs(child, map, path, mex, visited));

				path[next.val]--;

				if(path[next.val] == 0)
					mex.add(next.val);
			}
		}

		return max;
	}
}