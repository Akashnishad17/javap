import java.io.*;
import java.util.*;

class MultipleGames{

	public static class Node{

		int index;
		int val;

		public Node(int val, int index){
			this.index = index;
			this.val = val;
		}
	}
	
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);
		int m = Integer.parseInt(st[2]);

		st = br.readLine().split(" ");

		int[] arr = new int[n+1];

		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st[i-1]);

		int l, r;

		PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val == b.val ? a.index - b.index : a.val < b.val ? -1 : 1);

		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			l = Integer.parseInt(st[0]);
			r = Integer.parseInt(st[1]);

			if(arr[l] > m)
				continue;

			if(arr[r] + arr[l] <= m)
			{
				pq.add(new Node(arr[l], 0));
				pq.add(new Node(arr[r] + arr[l] - 1, 1));
			}

			else
			{
				pq.add(new Node(arr[l], 0));
				pq.add(new Node(m, 1));
			}
		}

		int max = 0;
		int count = 0;

		while(!pq.isEmpty())
		{
			Node node = pq.poll();

			if(node.index == 0)
				count++;
			else
				count--;

			max = Math.max(max, count);
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