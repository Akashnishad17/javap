import java.io.*;
import java.util.*;

class LongestCommonPrefix{

	public static class Trie{
		Trie[] child;
	}

	public static Trie getNode()
	{
		Trie trie = new Trie();
		trie.child = new Trie[26];
		return trie;
	}

	public static Trie root;

	public static void insert(String s)
	{
		Trie node = root;
		int index;

		for(int i = 0; i < s.length(); i++)
		{
			index = s.charAt(i) - 'a';
			
			if(node.child[index] == null)
				node.child[index] = getNode();

			node = node.child[index];
		}
	}

	public static String getPrefix()
	{
		Trie node = root;

		String res = "";
		int count, index;

		while(true)
		{
			count = 0;
			index = -1;
			
			for(int i = 0; i < 26; i++)
			{
				if(node.child[i] != null)
				{
					count++;
					index = i;
				}
			}

			if(count != 1)
				break;

			res += (char)(index+'a');
			node = node.child[index];
		}

		return res;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		root = getNode();

		for(String s : st)
			insert(s);

		System.out.print(getPrefix());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}