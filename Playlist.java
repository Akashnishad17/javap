import java.io.*;
import java.util.*;

class Playlist{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		HashSet<Integer> set = new HashSet<>();

		int l = 0, r = 0;
		int max = 1;
		
		while(r < n)
		{
			if(set.contains(arr[r]))
			{
				set.remove(arr[l]);
				l++;
			}
			else
			{
				set.add(arr[r]);
				r++;
				max = Math.max(r-l, max);
			}
		}

		System.out.print(max);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}