import java.io.*;
import java.util.*;

class SeparateThemAll {

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
			int q = nextInt();

			long[] deg = new long[n+1];
			long[] count = new long[n+1];

			boolean[] visited = new boolean[n+1];

			HashMap<Integer, List<Integer>> map = new HashMap<>();

			for(int i = 0; i < n - 1; i++)
			{
				int u = nextInt();
				int v = nextInt();

				deg[u]++;
				deg[v]++;
				count[u]++;
				count[v]++;

				List<Integer> child = map.getOrDefault(u, new ArrayList<>());
				child.add(v);
				map.put(u, child);

				child = map.getOrDefault(v, new ArrayList<>());
				child.add(u);
				map.put(v, child);
			}

			Queue<Integer> queue = new LinkedList<>();

			for(int i = 1; i <= n; i++)
			{
				if(count[i] == 1)
				{
					visited[i] = true;
					queue.add(i);
				}
			}

			long res = 0;

			while(queue.size() > 0)
			{
				int node = queue.poll();

				List<Integer> child = map.get(node);

				for(int c : child)
				{
					res += count[node] * count[c];

					if(count[node] > 0 && count[c] > 0)
					{
						count[node]--;
						count[c]--;
					}

					if(count[c] == 1)
						queue.add(c);
				}
			}

			println(res);

			while(q-- > 0)
			{
				int a = nextInt();
				int b = nextInt();
				int c = nextInt();
				int d = nextInt();

				long cost = deg[a] * deg[b];

				deg[a]--;
				deg[b]--;

				cost += (deg[c] + 1) * (deg[d] + 1);

				println(cost);

				deg[a]++;
				deg[b]++;
			}
		}
	}
}