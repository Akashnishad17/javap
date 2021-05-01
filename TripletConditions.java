import java.io.*;
import java.util.*;

class TripletConditions{

	static int binary_lower(int value, int[] arr, int n) 
	{ 
	    int start = 0; 
	    int end = n - 1; 
	    int ans = -1; 
	    int mid; 
	  
	    while (start <= end)  
	    { 
	        mid = (start + end) / 2; 
	        if (arr[mid] >= value)  
	        { 
	            end = mid - 1; 
	            ans = mid; 
	        } 
	        else
	            start = mid + 1;
	    } 
	    return ans; 
	} 

	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		int[] arr = new int[n];

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);
		int count = 0;

		for(int i = 2; i < n; i++)
		{
			int cur = binary_lower(arr[i] - k, arr, n); 

	        if(cur <= i - 2) 
	            count += ((i - cur) * (i - cur - 1))/2; 
		}

		return count;
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