import java.io.*;
import java.util.*;

class BitwiseBlend{
	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n+1];

		String[] st = br.readLine().split(" ");

		int first = -1;
		int second = -1;

		for(int i = 1; i <= n; i++)
		{
			arr[i] = Integer.parseInt(st[i-1]);

			if(i % 2 == 1 && arr[i] % 2 == 1 && first == -1)
				first = i;

			if(i % 2 == 0 && arr[i] % 2 == 1 && second == -1)
				second = i;
		}

		List<int[]> firstList = new ArrayList<>();
		List<int[]> secondList = new ArrayList<>();

		for(int i = 1; i <= n; i++)
		{
			if(first != -1 && i % 2 != arr[i] % 2)
				firstList.add(new int[]{i, first});

			if(second != -1 && i % 2 == arr[i] % 2)
				secondList.add(new int[]{i, second});
		}

		List<int[]> res = null;

		if(first != -1 && second != -1)
			res = firstList.size() < secondList.size() ? firstList : secondList;
		else if(first != -1)
			res = firstList;
		else if(second != -1)
			res = secondList;

		if(res == null)
			sb.append("-1\n");
		else
		{
			sb.append(res.size() + "\n");

			for(int[] a : res)
				sb.append(a[0] + " " + a[1] + "\n");
		}
	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
			solve(br);

		System.out.print(sb.toString());
	}
}