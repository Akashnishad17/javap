import java.io.*;
import java.util.*;

class LessenSum{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		long[] a = new long[n];
		long[] b = new long[n];

		String[] st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			a[i] = Long.parseLong(st[i]);

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			b[i] = Long.parseLong(st[i]);

		long k = Long.parseLong(br.readLine());

		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>(){
			
			@Override
			public int compare(long[] x, long[] y)
			{
				if(x[2] == y[2])
				{
					return (int)(y[0] % 2);
				}
				else
				{
					if(x[2] < y[2])
						return 1;
					return -1;
				}
			}
		});

		long sum = 0;

		for(int i = 0; i < n; i++)
		{
			pq.add(new long[]{a[i],b[i], a[i]*b[i]});
			sum += a[i]*b[i];
		}

		int alice = 0, bob = 0;

		while(sum > k && pq.size() > 0)
		{
			long[] x = pq.poll();

			sum -= x[2];
			x[0] /= 2;

			x[2] = x[0] * x[1];
			sum += x[2];

			if(x[2] != 0)
				pq.add(x);

			alice++;
		}

		pq.clear();
		sum = 0;

		for(int i = 0; i < n; i++)
		{
			pq.add(new long[]{b[i],a[i], b[i]*a[i]});
			sum += a[i]*b[i];
		}

		while(sum > k && pq.size() > 0)
		{
			long[] x = pq.poll();

			sum -= x[2];
			x[0] /= 2;

			x[2] = x[0] * x[1];
			sum += x[2];

			if(x[2] != 0)
				pq.add(x);

			bob++;
		}


		return alice == bob ? "Tie" : alice < bob ? "Alice" : "Bob";
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