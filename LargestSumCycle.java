import java.io.*;
import java.util.*;

class LargestSumCycle{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		boolean[] visited = new boolean[n];

		int node, pathSum, max = -1;

		for(int i = 0; i < n; i++)
		{
			node = i;
			pathSum = 0;

			while(arr[node] != i && arr[node] != -1 && !visited[node])
			{
				visited[node] = true;
				
				pathSum += node;
				node = arr[node];

				if(arr[node] == i)
				{
					pathSum += node;
					break;
				}
			}

			if(arr[node] == i)
				max = Math.max(max, pathSum);
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