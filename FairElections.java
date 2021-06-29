import java.io.*;
import java.util.*;

class FairElections{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		int diff = 0;

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
		{
			arr1[i] = Integer.parseInt(st[i]);
			diff += arr1[i];
		}

		st = br.readLine().split(" ");

		for(int i = 0; i < m; i++)
		{
			arr2[i] = Integer.parseInt(st[i]);
			diff -= arr2[i];
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int count = 0, l = 0, r = m - 1;

		while(diff <= 0 && l < n && r >= 0 && arr1[l] < arr2[r])
		{
			diff += 2 * (arr2[r] - arr1[l]);
			l++;
			r--;
			count++;
		}

		return diff > 0 ? count : -1;
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