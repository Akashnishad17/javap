import java.io.*;
import java.util.*;

class TreeInfection{

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

			int[] arr = new int[n + 1];
			int[] child = new int[n + 1];

			HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

			for(int i = 2; i <= n; i++)
			{
				arr[i] = nextInt();
				child[arr[i]]++;

				HashSet<Integer> ch = map.getOrDefault(arr[i], new HashSet<>());
				ch.add(i);
				map.put(arr[i], ch);
			}

			int count = 0;

			boolean[] infected = new boolean[n + 1];

			HashSet<Integer> set = new HashSet<>();

			Queue<Integer> queue = new LinkedList<>();

			for(int i = 2; i <= n; i++)
			{
				if(child[i] == 0)
					queue.add(i);
			}

			int node = queue.poll();

			infected[node] = true;
			count++;

			child[arr[node]]--;

			map.get(arr[node]).remove(node);

			if(child[arr[node]] > 0)
				set.add(arr[node]);
			else
				queue.add(arr[node]);

			int res = 0;

			while(count < n)
			{
				for(int x : set)
				{
					HashSet<Integer> ch = map.get(x);

					Iterator iter = ch.iterator();
					node = (Integer)iter.next();

					infected[node] = true;
					count++;
					child[x]--;

					if(child[x] == 0)
					{
						set.remove(x);
						queue.add(node);
					}
				}

				node = queue.poll();

				while(queue.size() > 0 && infected[node])
					node = queue.poll();
				
				if(!infected[node])
				{
					infected[node] = true;
					count++;

					child[arr[node]]--;

					if(child[arr[node]] > 0)
						set.add(arr[node]);
					else
						queue.add(arr[node]);

				}

				res++;
			}

			println(res);
		}
	}
}