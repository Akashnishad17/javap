import java.io.*;
import java.util.*;

class LunchTime{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		for( int i = 0 ; i < n ; i++ )
        {
	        int count = 0 ; 
	        for( int j = i-1 ; j >= 0 ; j-- )
	        {
	               if( arr[i] < arr[j] )
	                        break;
	               if( arr[i] == arr[j] )
	               {
	                       count++ ;
	               }
	        }
	        for( int j = i+1 ; j < n ; j++ )
	        {
	               if( arr[i] < arr[j] )
	                        break;
	               if( arr[i] == arr[j] )
	               {
	                       count++ ;
	               }
	        }
	        System.out.print(count+" ");
        }

        System.out.println();
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