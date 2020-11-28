import java.io.*;
import java.util.*;

class HIndex{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int x, index = 0;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(n, (a,b) -> a - b);

		for(int i = 0; i < n; i++)
		{
			x = Integer.parseInt(st[i]);
			
			if(x > index)
				pq.add(x);

			while(!pq.isEmpty() && (int)pq.peek() <= index)
				pq.remove();

			if(pq.size() >= index+1)
				index++;

			sb.append(index+" ");
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}