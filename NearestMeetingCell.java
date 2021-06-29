import java.io.*;
import java.util.*;

class NearestMeetingCell{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		st = br.readLine().split(" ");

		int src = Integer.parseInt(st[0]);
		int dest = Integer.parseInt(st[1]);

		HashSet<Integer> set = new HashSet<>();

		List<Integer> srcPath = new ArrayList<>();
		List<Integer> destPath = new ArrayList<>();

		dfs(src, set, arr, srcPath);
		set.clear();
		dfs(dest, set, arr, destPath);

		set.clear();
		set.addAll(srcPath);

		for(int x : destPath)
		{
			if(set.contains(x))
				return x;
		}

		return -1;
	}

	public static void dfs(int node, HashSet<Integer> set, int[] arr, List<Integer> path)
	{
		while(!set.contains(node) && node != -1)
		{
			set.add(node);
			path.add(node);
			node = arr[node];
		}
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