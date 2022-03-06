import java.io.*;
import java.util.*;

class MagnetSort{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];
		int[] temp = new int[n];

		boolean sorted = true;

		for(int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(st[i]);
			temp[i] = arr[i];

			if(i > 0 && arr[i-1] > arr[i])
				sorted = false;
		}

		String s = br.readLine();

		int polar = 0;

		for(int i = 0; i < n; i++)
			polar |= s.charAt(i) == 'N' ? 1 : 2;

		if(sorted)
			return 0;

		if(polar != 3)
			return -1;


		if(s.charAt(0) != s.charAt(n-1))
			return 1;

		Arrays.sort(temp);

		for(int i = 0; i < n; i++)
		{
			if(s.charAt(i) != s.charAt(n - 1))
				return 1;

			if(arr[i] != temp[i])
				break;
		}

		for(int i = n - 1; i >= 0; i--)
		{
			if(s.charAt(i) != s.charAt(0))
				return 1;

			if(arr[i] != temp[i])
				break;
		}

		return 2;
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