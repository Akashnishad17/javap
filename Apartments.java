import java.io.*;
import java.util.*;

class Apartments{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		int[] app = new int[m];

		int i, j;

		for(i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		for(j = 0; j < m; j++)
			app[j] = sc.nextInt();

		Arrays.sort(arr);
		Arrays.sort(app);

		i = 0; 
		j = 0;
		int count = 0;

		while(i < n && j < m)
		{
			if(app[j] - k <= arr[i] && arr[i] <= app[j] + k)
			{
				count++;
				i++;
				j++;
			}

			else if(app[j] - k > arr[i])
				i++;

			else if(app[j] + k < arr[i])
				j++;
		}

		System.out.print(count);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}