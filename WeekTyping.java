import java.io.*;
import java.util.*;

class WeekTyping{
	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		int mod = 1000000007;

		String s = br.readLine();

		long[] prefix = new long[n];

		// 0 -> pos for O
		// 1 -> pos for X
		long[][] suffix = new long[n][2];
		suffix[n-1][0] = suffix[n-1][1] = -1;

		// 0 -> no affects
		// pos -> last index of O
		// neg -> last index of X 
		int[] prev = new int[n+1];

		long sum = 0;

		char last = s.charAt(0);

		for(int i = 1; i < n; i++)
		{
			prefix[i] = prefix[i-1];

			if((s.charAt(i) == 'O' && last == 'X') || (s.charAt(i) == 'X' && last == 'O'))
				prefix[i]++;

			if(s.charAt(i) != 'F')
				last = s.charAt(i);

			sum = (sum + prefix[i]) % mod;

			if(s.charAt(i-1) == 'O')
				prev[i+1] = i;
			else if(s.charAt(i-1) == 'X')
				prev[i+1] = -i;
			else
				prev[i+1] = prev[i];
		}

		long res = sum;

		for(int i = n - 1; i >= 0; i--)
		{
			if(s.charAt(i) == 'O')
				suffix[i][0] = i;
			else if(i + 1 < n)
				suffix[i][0] = suffix[i+1][0];

			if(s.charAt(i) == 'X')
				suffix[i][1] = i;
			else if(i + 1 < n)
				suffix[i][1] = suffix[i+1][1];
		}

		long temp;

		for(int i = 1; i < n; i++)
		{
			temp = 0;

			if(prev[i+1] != 0)
			{
				if(prev[i+1] > 0)
				{
					temp = (prefix[prev[i+1]] * (n - prev[i+1])) % mod;

					if(suffix[i][1] != -1)
						temp = (temp + n - suffix[i][1]) % mod;

					res = (res + sum - temp) % mod;
				}
				else
				{
					temp = (prefix[-prev[i+1]] * (n + prev[i+1])) % mod;

					if(suffix[i][0] != -1)
						temp = (temp + n - suffix[i][0]) % mod;

					res = (res + sum - temp) % mod;
				}
			}
		}

		for(int i = 0; i < n; i++)
		{
			System.out.println(prefix[i]+" "+prev[i+1]+" "+suffix[i][0]+" "+suffix[i][1]);
		}

		return res;
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

/*1
10
FXXFXFOOXF
3
XFO
1
O
5
FFOFF
13
XFOFXFOFXFOFX*/