import java.io.*;
import java.util.*;

class Traveller{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		if(n == 1)
		{
			System.out.print("Invalid Input");
			return;
		}

		Arrays.sort(arr);

		if(arr[0] == arr[n-1])
		{
			System.out.print("Equal");
			return;
		}

		System.out.print(arr[0]+" "+arr[1]);

	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}