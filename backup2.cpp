import java.io.*;
import java.util.*;

class MagicalCandyStore{

	public static int mod = 1000000007;

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int[] arr = new int[n+1];
		int index = -1;

		for(int i = 1; i <= n; i++)
		{
			arr[i] = Integer.parseInt(st[i-1]);
			if(arr[i] == 1)
				index = i;
		}

		int[] score = new int[n+1];

		if(index == -1 || index == n)
		{
			for(int i = 1; i <= n; i++)
			{
				score[i] = score[i-1];
				if(i == n)
					score[i] = (score[i] + arr[i] - (arr[i] % 2 == 0 ? 1 : 0)) % mod; 
				else
					score[i] = (score[i] + 2 * (arr[i]/2)) % mod;
			}
		}
		else if(index == 1)
		{
			for(int i = 1; i <= n; i++)
				score[i] = 1;
		}
		else
		{
			for(int i = 1; i <= n; i++)
			{
				score[i] = score[i-1];

				if(i == index-1 || i == n)
					score[i] = (score[i] + arr[i] - (arr[i] % 2 == 0 ? 1 : 0)) % mod;
				else if(index != i)
					score[i] = (score[i] + 2 * (arr[i]/2)) % mod;
			}
		}

		for(int i = 1; i <= n; i++)
			System.out.print(score[i]+" ");
		System.out.println();

		int q = Integer.parseInt(br.readLine());

		long r, rounds, val;
		int in;
		while(q-- > 0)
		{
			r = Integer.parseInt(br.readLine());

			rounds = r / n % mod;
			in = (int)(r % n);
			val = (rounds*score[n] + score[in]) % mod;

			/*if(in == 0)
				in = n;

			if(index == -1 || index == n)
			{
				if(in == n)
				{
					if(arr[n] % 2 == 0)
						val++;
				}
				else if(arr[in] % 2 != 0)
					val++;
			}
			else if(index > 1)
			{
				if(in > index)
				{
					if(in == n)
					{
						if(arr[n] % 2 == 0)
							val++;
					}
					else if(arr[in] % 2 != 0)
						val++;
				}
				else if(in < index-1)
				{
					if(arr[in] % 2 != 0)
						val++;
				}
				else
				{
					if(arr[index-1] % 2 == 0)
						val++;

					if(in == index)
						val++;
				}
			}*/

			val %= mod;

			System.out.println(val);
		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}

/*
4
4
4 10 2 1
2
4
5
6
4 2 1 6 8 3
5
7
14
20
32
3
3
1 2 3
5
1
2
3
5
9
1
1
5
1
2
3
4
5
*/


/*
8
4
4 10 2 1
2
4
5
6
4 2 1 6 8 3
5
7
14
20
32
3
3
1 2 3
5
1
2
3
5
9
1
1
5
1
2
3
4
5
4
4 3 1 8
1
4
5
1 2 3 4 5
12
1
2
3
4
5
6
7
8
9
10
11
12
5
2 3 1 4 5
3
4
5
6
2
1 2
5
1
3
7
8
14
*/