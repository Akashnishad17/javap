import java.io.*;
import java.util.*;

class MagicalModulo {
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n+1];

		for(int i = 0; i < n; i++)
			arr[i + 1] = Integer.parseInt(st[i]);

		for(int i = 1; i <= n; i++)
		{
			while(arr[i] != i)
			{
				int temp = arr[i];

				if(temp > n)
					break;

				if(arr[temp] == temp)
					break;

				arr[i] = arr[temp];
				arr[temp] = temp;
			}
		}

		List<Integer> list = new ArrayList<>();
		List<Integer> index = new ArrayList<>();

		int min = 10000000 - 1;

		for(int i = 1; i <= n; i++)
		{
			if(arr[i] != i)
			{
				if(arr[i] <= n + 1)
					return "NO";

				min = Math.min(arr[i] - 1);
				list.add(arr[i]);
				index.add(i);
			}
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