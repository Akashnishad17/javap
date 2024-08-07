import java.util.*;

public class PerfectlyEven
{
    private static int mod = 1000000007;
    private static int[][] dir = new int[][]{{1, 1}, {1, 0}, {0, 1}, {0, 0}};
    private static HashMap<String, Long> map = new HashMap<>();
    
	public static void main(String[] args) {
		int n = 2;
		int m = 2;
		int k = 0;
		long res = 0;
		
		for(int[] d : dir)
		    res = (res + dfs(n, m / 2, (m + 1) / 2, d[0], d[1], k)) % mod; 
		
		System.out.println(res);
	}
	
	private static long dfs(int n, long even, long odd, int b1, int b2, int k)
	{
	   if(n == 1)
	        return b1 == b2 && k == 0 ? b1 == 1 ? even : odd : 0;
	   
	   String key = n + " " + b1 + " " + b2 + " " + k;
	   
	   if(map.containsKey(key))
	        return map.get(key);
	   
	   int mid = n / 2;
	   int rem = n - mid;
	   long res = 0;
	        
	   for(int i = 0; i <= k; i++)
	   {
	       for(int[] d : dir)
	       {
	           int temp = d[0] == 1 && d[1] == 1 ? 1 : 0;
	           if(mid >= i - 1 && rem >= k - i - 1 - temp)
	           {
    	           long left = dfs(mid, even, odd, b1, d[0], i);
    	           long right = dfs(rem, even, odd, d[1], b2, k - i - temp);
    	           res = (res + (left * right) % mod) % mod;
	           }
	       }
	   }
	   
	   map.put(key, res);
	   return res;
	}
}
