import java.io.*;
import java.util.*;

class AndOrGame{

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[] arr1 = new int[n];
		int[] arr2 = new int[m];

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr1[i] = Integer.parseInt(st[i]);

		st = br.readLine().split(" ");

		for(int i = 0; i < m; i++)
			arr2[i] = Integer.parseInt(st[i]);

		Stack<Integer> stack = new Stack<>();
		stack.add(0);

		HashSet<Integer> set = new HashSet<>();
		set.add(0);

		int v;

		while(!stack.isEmpty())
		{
			v = stack.pop();

			for(int x : arr1)
			{
				if(!set.contains(v | x))
				{
					set.add(v | x);
					stack.add(v | x);
				}
			}

			for(int x : arr2)
			{
				if(!set.contains(v & x))
				{
					set.add(v & x);
					stack.add(v & x);
				}
			}
		}

		return set.size();
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