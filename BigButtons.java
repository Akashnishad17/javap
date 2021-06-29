import java.io.*;
import java.util.*;

class BigButtons{

	public static class Trie{
		Trie[] child;
		boolean end;
	}

	public static Trie getNode()
	{
		Trie trie = new Trie();
		trie.child = new Trie[2];
		return trie; 
	}

	public static Trie root;

	public static void insert(String s)
	{
		int index;
		Trie node = root;

		for(int i = 0; i < s.length(); i++)
		{
			index = s.charAt(i) == 'B' ? 0 : 1;
			
			if(node.child[index] == null)
				node.child[index] = getNode();

			node = node.child[index];
		}

		node.end = true;
	}

	public static long dfs(Trie node, long count)
	{
		if(node == null)
			return count;

		if(node.end)
			return 0;

		long left = dfs(node.child[0], count/2);
		long right = dfs(node.child[1], count/2);

		return left + right;
	}
	
	public static long solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int p = Integer.parseInt(st[1]);

		root = getNode();

		while(p-- > 0)
			insert(br.readLine());

		return dfs(root, (long)Math.pow(2, n));
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