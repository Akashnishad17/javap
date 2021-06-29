import java.io.*;
import java.util.*;

class Dragons{
	public static void solve(Scanner sc)
	{
		int s = sc.nextInt();
		int n = sc.nextInt();
		int[][] dr = new int[n][2];
		int i;
		
		for(i = 0; i < n; i++)
		{
			dr[i][0] = sc.nextInt();
			dr[i][1] = sc.nextInt();
		}

		Arrays.sort(dr, new Comparator<int[]>(){
			@Override
			public int compare(int[] A, int[] B)
			{
				if(A[0] != B[0])
					return A[0] - B[0];
				return B[1] - A[1];
			}
		});

		for(i = 0; i < n; i++)
		{
			if(s <= dr[i][0])
				break;
			s += dr[i][1];
		}

		String res = i == n ? "YES" : "NO";
		System.out.println(res);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input4.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
		{
			solve(sc);
		}
	}
}