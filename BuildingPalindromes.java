import java.io.*;
import java.util.*;

class BuildingPalindromes{

	public static boolean isValid(int[] t)
	{
		int odd = 0;

		for(int x : t)
		{
			if(x % 2 != 0)
				odd++;
		}

		return odd <= 1;
	}

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int q = Integer.parseInt(st[1]);

		String s = br.readLine();

		int[][] arr = new int[n+1][26];

		for(int i = 1; i <= n; i++)
		{
			for(int j = 0; j < 26; j++)
				arr[i][j] = arr[i-1][j];

			arr[i][s.charAt(i-1) - 'A']++;
		}

		int count = 0, l, r;
		int[] temp = new int[26]; 


		while(q-- > 0)
		{
			st = br.readLine().split(" ");
			l = Integer.parseInt(st[0]);
			r = Integer.parseInt(st[1]);

			for(int i = 0; i < 26; i++)
				temp[i] = arr[r][i] - arr[l-1][i];

			if(isValid(temp))
				count++;
		}

		return count;
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