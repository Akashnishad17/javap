import java.io.*;
import java.util.*;

class NumberPuzzle2{

	public static String solve(int[][] A)
	{
		int[] arr = new int[16];

		int index = 0;

		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
				arr[index++] = A[i][j];
		}

		int inv = 0;

		for(int i = 0; i < 16; i++)
		{
			if(arr[i] > 0)
			{
				for(int j = 0; j < i; j++)
				{
					if(arr[j] > arr[i])
						inv++;
				}
			}
		}

		for(int i = 0; i < 16; i++)
		{
			if(arr[i] == 0)
				inv += 1 + i/4;
		}

		return (inv & 1 > 0) ? "YES" : "NO";
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			int[][] A = new int[4][4];

			for(int i = 0; i < 4; i++)
			{
				String[] st = br.readLine().split(" ");
				
				for(int j = 0; j < 4; j++)
					A[i][j] = Integer.parseInt(st[j]);
			}

			System.out.println(solve(A));
		}
	}
}