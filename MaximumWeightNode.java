import java.io.*;
import java.util.*;

class MaximumWeightNode{

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		st = br.readLine().split(" ");

		int[] sum = new int[n];
       
        for(int i = 0 ; i < n; i++) 
        {
            if(arr[i] != -1)
                sum[arr[i]] += i;
        }

        int max = 0;
        int ans = 0;
        
        for(int i = 0; i < n; i++ )
        {
            if(max < sum[i]) 
            {
                ans = i;
                max = sum[i];
            }
        }
        
        return ans;
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