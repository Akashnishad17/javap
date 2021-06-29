import java.io.*;
import java.util.*;

class Sum{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		
		if(n < 1 || n > 100000)
		{
			System.out.print("WRONG INPUT");
			return;
		}

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
			
			if(arr[i] < 1 || arr[i] > 100000)
			{
				System.out.print("WRONG INPUT");
				return;
			}
		}

		try{
			if(br.readLine() != null)
			{
				System.out.print("WRONG INPUT");
				return;
			}
		}catch(Exception e)
		{

		}

		int sum = arr[0];

		for(int i = 1; i < n; i++)
		{
		    if(arr[i-1] >= arr[i])
		        arr[i] = arr[i-1] + 1;
		        
		    sum += arr[i];
		}

		System.out.print(sum);		

	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}