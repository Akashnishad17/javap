import java.io.*;
import java.util.*;

class MatrixCell{

	public static int[] solve(int n, int[][] q, int k)
	{
		int empty = n*n;
		int[] res = new int[k];
		HashSet<Integer> X = new HashSet<>();
		HashSet<Integer> Y = new HashSet<>();
		int x, y;
		for(int i = 0; i < k; i++)
		{	
			x = q[i][0];
			y = q[i][1];
			if(X.contains(x) && Y.contains(y));
			else if(X.contains(x))
				empty -= (n - X.size());
			else if(Y.contains(y))
				empty -= (n - Y.size());
			else
				empty -= (2*n - 1 - X.size() - Y.size());
			X.add(x);
			Y.add(y);
			res[i] = empty;
		}
		return res;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] q = new int[k][2];
			for(int i = 0; i < k; i++)
			{
				q[i][0] = sc.nextInt();
				q[i][1] = sc.nextInt();
			}
			int[] res = solve(n, q, k);
			for(int x : res)
				System.out.print(x+" ");
			System.out.println();
		}
	}
}