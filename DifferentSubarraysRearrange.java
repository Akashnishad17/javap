import java.io.*;
import java.util.*;

class DifferentSubarraysRearrange{

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

			HashMap<Integer, Integer> map = new HashMap<>();

			for(int i = 0; i < n; i++)
			{
				int x = nextInt();
				map.put(x, map.getOrDefault(x, 0) + 1);
			}

			if(map.size() < 3)
				println("NO");
			else
			{
				int size = map.size();
				int[][] arr = new int[size][2];

				int k = 0;

				for(int x : map.keySet())
				{
					arr[k][0] = x;
					arr[k][1] = map.get(x);
					k++;
				}

				Arrays.sort(arr, (a, b) -> a[1] - b[1]);

				int last = arr[size-1][1];

				if(last > n / 2)
					println("NO");
				else
				{
					int[] a = new int[n];
					int[] b = new int[n];

					int j = 0;

					for(int i = 0; i < n; i++)
					{
						if(arr[j][1] == 0)
							j++;

						a[i] = arr[j][0];
						b[(i + last) % n] = arr[j][0];

						arr[j][1]--;
					}

					println("YES");

					for(int x : a)
						print(x + " ");

					println();

					for(int x : b)
						print(x + " ");

					println();
				}
			}
		}
	}
}