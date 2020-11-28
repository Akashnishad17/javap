import java.io.*;
import java.util.*;
class DelayedProject{

	public static List<Character> solve(char[][] arr, int n, char[] q, int k)
	{
		HashMap<Character,List<Character>> map = new HashMap<>();
		for(char[] d : arr)
		{
			List<Character> dep = map.getOrDefault(d[1], new ArrayList<>());
			dep.add(d[0]);
			map.put(d[1], dep);
		}
		int[] dp = new int[26];
		for(char c : q)
			dfs(c, dp, map);
		List<Character> res = new ArrayList<>();
		for(int i = 0; i < 26; i++)
		{
			if(dp[i] > 0)
				res.add((char)(i+'A'));
		}
		return res;
	}

	public static void dfs(char c, int[] dp, HashMap<Character,List<Character>> map)
	{
		List<Character> dep = map.getOrDefault(c, new ArrayList<>());
		dp[c - 'A']++;
		for(char d : dep)
			dfs(d, dp, map);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int a = 1; a <= t; a++)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			char[][] depend = new char[n][2];
			char[] delayed = new char[k];
			for(int i = 0; i < n; i++)
			{
				depend[i][0] = sc.next().charAt(0);
				depend[i][1] = sc.next().charAt(0);
			}
			for(int i = 0; i < k; i++)
				delayed[i] = sc.next().charAt(0);
			List<Character> res = solve(depend, n, delayed, k);
			System.out.print("Case #"+a+":");
			for(char c : res)
				System.out.print(" "+c);
			System.out.println();
		}
	}
}