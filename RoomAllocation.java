import java.io.*;
import java.util.*;

class RoomAllocation{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int a, b;

		for(int i = 0; i < n; i++)
		{
			String[] st = br.readLine().split(" ");

			a = Integer.parseInt(st[0]);
			b = Integer.parseInt(st[1]);

			pq.add(new int[]{a, 0});
			pq.add(new int[]{b, 1});
		}

		int count = 0, max = 0;

		while(pq.size() > 0)
		{
			int[] x = pq.poll();

			if(x[1] == 0)
				count++;
			else
				count--;

			max= Math.max(max, count);
		}

		return max;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}