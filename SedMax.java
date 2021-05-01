import java.io.*;
import java.util.*;

class SedMax{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		HashSet<Integer> set = new HashSet<>();

		for(int i = 0; i < n-1; i++)
		{
			int max = Math.max(arr[i],arr[i+1]);
			int max2 = Math.min(arr[i], arr[i+1]);

			set.add(max - max2);

			for(int j = i+2; j < n; j++)
			{
				if(arr[j] >= max)
				{
					max2 = max;
					max = arr[j];
				}
				else
					max2 = Math.max(max2, arr[j]);

				set.add(max - max2);
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