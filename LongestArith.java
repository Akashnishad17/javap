import java.io.*;
import java.util.*;
class LongestArith{
    
    public static int solve(int[] arr, int n)
    {
        int len = 1;
        int max = 1;
        int prev = 0;
        for(int i = 1; i < n; i++)
        {
            if(i > 1 && arr[i] - arr[i-1] == prev)
                len++;
            else
                len = 1;
            max = Math.max(len, max);
            prev = arr[i] - arr[i-1];
        }
        return max+1;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int res = solve(arr, n);
        System.out.print(res);
    }
}