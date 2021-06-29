import java.io.*;
import java.util.*;

class MaximumSumDigit{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> child;
		int sum;

		for(int x : arr)
		{
			sum = digitSum(x);
			child = map.getOrDefault(sum, new ArrayList<>());
			child.add(x);
			map.put(sum, child);
		}

		int max = -1;

		for(Map.Entry<Integer, List<Integer>> e : map.entrySet())
		{
			child = e.getValue();
			Collections.sort(child);

			if(child.size() > 1)
				max = Math.max(max, child.get(child.size()-1) + child.get(child.size()-2));
		}

		return max;
	}

	public static int digitSum(int x)
	{
		int sum = 0;

		while(x > 0)
		{
			sum += x % 10;
			x /= 10;
		}

		return sum;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}