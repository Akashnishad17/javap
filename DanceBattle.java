import java.io.*;
import java.util.*;

class DanceBattle{

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int e = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);
		
		st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);

		int l = 0, r = n - 1;
		int honor = 0, max = 0;

		while(l <= r)
		{
			while(l <= r && e > arr[l])
			{
				e -= arr[l];
				honor++;
				l++;
			}

			if(honor == 0)
				break;

			max = Math.max(max, honor);

			if(l <= r)
			{
				honor -= 1;
				e += arr[r--];
			}
		}

		return max;
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