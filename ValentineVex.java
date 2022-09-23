import java.io.*;
import java.util.*;

class ValentineVex{

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

			List<Long> even = new ArrayList<>();
			List<Long> odd = new ArrayList<>();

			for(int i = 0; i < n; i++)
			{
				long x = nextLong();

				if(x % 2 == 0)
					even.add(x);
				else
					odd.add(x);
			}

			Collections.sort(even);
			Collections.sort(odd);

			int l1 = even.size() - 1;
			int l2 = odd.size() - 1;

			//long min1 = Math.min(helper(0, l1, l2, true, true, even, odd), helper(0, l1, l2, true, false, even, odd));
			//long min2 = Math.min(helper(0, l1, l2, false, true, even, odd), helper(0, l1, l2, false, false, even, odd));

			// long m1 = helper(0, l1, l2, true, true, even, odd);
			// long m2 = helper(0, l1, l2, true, false, even, odd);
			// long m3 = helper(0, l1, l2, false, true, even, odd);
			// long m4 = helper(0, l1, l2, false, false, even, odd);

			long min1 = help(l1, l2, true, even, odd);
			long min2 = help(l1, l2, false, even, odd);

			println(Math.max(min1, min2));

			//print(m1 + " " + m2 + " " + m3 + " " + m4 + " ");

			//println(Math.max(Math.min(m1, m4), Math.min(m2, m3)));
		}
	}

	private static long help(int l1, int l2, boolean flag, List<Long> even, List<Long> odd) throws Exception{
		if(flag){
			long bob1 = helper(0, l1 - 1, l2, true, !flag, even, odd);
			long bob2 = helper(0, l1 - 1, l2, false, !flag, even, odd);

			long alice1 = helper(even.get(l1), l1 - 1, l2 - 1, !flag, true, even, odd);
			long alice2 = helper(even.get(l1), l1 - 2, l2, !flag, false, even, odd);

			println(bob1 + " " + bob2 + " "  + alice1 + " " + alice2);

			if(bob1 == bob2)
				return Math.min(alice1, alice2);
			else if(bob1 > bob2)
				return alice1;
			else
				return alice2;
		}
		else{
			long bob1 = helper(0, l1, l2 - 1, true, !flag, even, odd);
			long bob2 = helper(0, l1, l2 - 1, false, !flag, even, odd);

			long alice1 = helper(odd.get(l2), l1, l2 - 2, !flag, true, even, odd);
			long alice2 = helper(odd.get(l2), l1 - 1, l2 - 1, !flag, false, even, odd);

			println(bob1 + " " + bob2 + " "  + alice1 + " " + alice2);

			if(bob1 == bob2)
				return Math.min(alice1, alice2);
			else if(bob1 > bob2)
				return alice1;
			else
				return alice2;
		}
	}

	private static long helper(long alice, int i, int j, boolean f1, boolean f2, List<Long> even, List<Long> odd){
		if((f1 && i < 0) || (!f1 && j < 0))
			return alice;

		if(f1)
			return helper(alice + even.get(i), i - 1 - (f2 ? 1 : 0), j - (f2 ? 0 : 1), !f1, !f2, even, odd);
		else
			return helper(alice + odd.get(j), i - (f2 ? 1 : 0), j - 1 - (f2 ? 0 : 1), !f1, !f2, even, odd);
	}
}