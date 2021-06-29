import java.io.*;
import java.util.*;

class JosephusProblem1{

	public static class Node{
		int val;
		Node prev, next;

		public Node(int val){
			this.val = val;
		}
	}

	private static Node root = null;

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		Node temp = root;

		for(int i = 1; i <= n; i++)
		{
			Node node = new Node(i);

			if(root == null)
			{
				root = node;
				temp = node;
			}
			else
			{
				node.prev = temp;
				temp.next = node;
				temp = temp.next;
			}
		}

		root.prev = temp;
		temp.next = root;

		StringBuilder sb = new StringBuilder();

		while(n-- > 0)
		{
			root = root.next;

			sb.append(root.val+" ");

			if(n > 0)
			{
				Node prev = root.prev;
				Node next = root.next;

				next.prev = prev;
				prev.next = next;

				root = next;
			}
		}

		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}