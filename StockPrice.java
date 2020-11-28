import java.io.*;
import java.util.*;

class StockPrice{

	public static String maxProfit(int[] prices) 
	{   
        int s1 = -prices[0], b1 = Integer.MIN_VALUE;
        
        for(int i = 1; i < prices.length; i++)
        {
            s1 = Math.max(s1, -prices[i]);
            b1 = Math.max(b1, s1+prices[i]);
        }

        return ""+(-s1)+","+(b1-s1);
    }

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(",");

		int n = st.length;
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		System.out.print(maxProfit(arr));
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}