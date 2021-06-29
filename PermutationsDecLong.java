import java.io.*;
import java.util.*;

class PermutationsDecLong{

	public static int[] arr;
	public static int[] res;
	public static int n;
	public static String s;

	public static void permute(int l, int r)
	{
		if(l == r)
		{
			int k = 0;

			for(int i = 1; i < n; i++)
			{
				if(arr[i] % arr[i-1] == 0)
				{
					if(s.charAt(arr[i]/arr[i-1] - 1) == '1')
						k++;
				}
			}

			res[k]++;
		}
		else
		{
			for(int i = l; i <= r; i++)
			{
				swap(i, l);
				permute(l+1, r);
				swap(i, l);
			}
		}
	}

	public static void swap(int l, int r)
	{
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		n = Integer.parseInt(br.readLine());
		s = br.readLine();

		arr = new int[n];
		res = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = i+1;

		permute(0, n-1);

		for(int i = 0; i < n; i++)
			System.out.print(res[i]+" ");
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}