import java.io.*;
import java.util.*;

class PaparazziGennady{

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		long[] arr = new long[n];
		String[] s = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(s[i]);


		List<long[]> list = new ArrayList<>();

		list.add(new long[]{0, arr[0]});
		list.add(new long[]{1, arr[1]});

		long max = 1;

		for(int i = 2; i < n; i++)
		{
			while(list.size() >= 2)
			{
				long[] last = list.get(list.size() - 1);
				long[] first = list.get(list.size() - 2);

				if((last[1] - first[1]) * (i - last[0]) <= (arr[i] - last[1]) * (last[0] - first[0]))
					list.remove(list.size() - 1);
				else
					break;
			}

			list.add(new long[]{i, arr[i]});

			long[] last = list.get(list.size() - 1);
			long[] first = list.get(list.size() - 2);

			max = Math.max(max, last[0] - first[0]);
		}

		return max;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}