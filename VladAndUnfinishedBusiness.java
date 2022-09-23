import java.io.*;
import java.util.*;

public class VladAndUnfinishedBusiness{

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
			next();

			int n = nextInt();
			int k = nextInt();

			int x = nextInt();
			int y = nextInt();

			boolean[] place = new boolean[n + 1];

			for(int i = 0; i < k; i++)
			{
				int temp = nextInt();
				place[temp] = true;
			}

			place[x] = true;
			place[y] = true;

			HashMap<Integer, List<Integer>> map = new HashMap<>();

			for(int i = 0; i < n - 1; i++)
			{
				int u = nextInt();
				int v = nextInt();

				List<Integer> child = map.getOrDefault(u, new ArrayList<>());
				child.add(v);
				map.put(u, child);

				child = map.getOrDefault(v, new ArrayList<>());
				child.add(u);
				map.put(v, child);
			}

			boolean[] visited = new boolean[n+1];
			visited[x] = true;

			int count = getCount(x, visited, place, map);
			count--;

			visited = new boolean[n+1];
			visited[x] = true;

			int shortPath = getShortPath(x, y, map, 0, visited);

			println((count - shortPath) * 2 + shortPath);
		}
	}

	private static int getShortPath(int node, int target, HashMap<Integer, List<Integer>> map, int total, boolean[] visited){
		if(node == target)
			return total;

		List<Integer> child = map.getOrDefault(node, new ArrayList<>());

		int count = -1;

		for(int x : child)
		{
			if(!visited[x])
			{
				visited[x] = true;

				int temp = getShortPath(x, target, map, total + 1, visited);

				if(temp != -1)
					count = temp;
			}
		}

		return count;
	}

	private static int getCount(int node, boolean[] visited, boolean[] place, HashMap<Integer, List<Integer>> map){
		List<Integer> child = map.getOrDefault(node, new ArrayList<>());

		int count = 0;

		for(int x : child)
		{
			if(!visited[x])
			{
				visited[x] = true;
				count += getCount(x, visited, place, map);
			}
		}

		if(place[node] || count > 0)
			count++;

		return count;
	}
}