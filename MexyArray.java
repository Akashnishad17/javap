import java.io.*;
import java.util.*;

class MexyArray{

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

	private static void solve() throws Exception {	
		int t = nextInt();

		while(t-- > 0)
		{
			int n = nextInt();

			int[] arr = new int[n];

			TreeSet<Integer> set = new TreeSet<>();

			for(int i = 0; i < n; i++)
			{
				arr[i] = nextInt();
				set.add(i);
			}	

			Stack<Integer> stack = new Stack<>();

			boolean valid = true;

			for(int i = 0; i < n; i++)
			{
				if(arr[i] != -1)
				{
					if(arr[i] - 1 > i)
					{
						valid = false;
						break;
					}

					if(stack.size() > 0)
					{
						if((int)stack.peek() > arr[i])
						{
							valid = false;
							break;
						}
					}
					stack.add(arr[i]);
				}

			}

			if(!valid)
				println(-1);
			else
			{
				int count = 0;
				int[] res = new int[n];

				for(int i = n - 1; i >= 0; i--)
				{
					if(arr[i] == -1)
					{
						res[i] = set.last();
						set.remove(res[i]);
					}
					else
					{
						stack.pop();

						if(stack.size() == 0)
						{
							res[i] = set.last();
							set.remove(res[i]);

							if(set.contains(arr[i]))
							{
								set.remove(arr[i]);
								set.add(n + count++);
							}
						}
						else
						{
							int last = stack.peek();

							if(set.contains(last))
							{
								res[i] = last;
								set.remove(res[i]);

								if(set.contains(arr[i]))
								{
									set.remove(arr[i]);
									set.add(n + count++);
								}
							}
							else
							{
								res[i] = set.last();
								set.remove(res[i]);

								if(set.contains(arr[i]))
								{
									set.remove(arr[i]);
									set.add(n + count++);
								}
							}
						}

						if(set.contains(arr[i]))
						{
							set.remove(arr[i]);
							set.add(n + count++);
						}
					}
				}

				for(int x : res)
					print(x + " ");

				println();
			}
		}
	}
}