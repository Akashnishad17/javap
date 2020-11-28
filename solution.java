public class solution {
    static int min = Integer.MAX_VALUE;
    public static int solve(int src, int dest) {
        int[][] board = new int[8][8];
        backTrack(board, src/8, src%8, dest/8, dest%8, 0);
        return min;
    }
    public static void backTrack(int[][] board, int row, int col, int tarX, int tarY, int steps)
    {
        if(row < 0 || col < 0 || row >= 8 || col >= 8 || board[row][col] == 1)
            return;
        if(row == tarX && col == tarY)
        {
            if(steps < min)
                min = steps;
            return;
        }
        board[row][col] = 1;
        backTrack(board, row+2, col+1, tarX, tarY, steps+1);
        backTrack(board, row+2, col-1, tarX, tarY, steps+1);
        backTrack(board, row-2, col+1, tarX, tarY, steps+1);
        backTrack(board, row-2, col-1, tarX, tarY, steps+1);
        backTrack(board, row+1, col+2, tarX, tarY, steps+1);
        backTrack(board, row+1, col-2, tarX, tarY, steps+1);
        backTrack(board, row-1, col+2, tarX, tarY, steps+1);
        backTrack(board, row-1, col-2, tarX, tarY, steps+1);
        board[row][col] = 0;
    }
    public static void main(String[] args)
    {
    	System.out.print(solve(0,1));
    }
}

/*import java.util.*;
import java.io.*;
import java.lang.*;

class solution{
    
    public static int perfectSubarray(int[] arr, int n)
    {
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            for(int j = i; j < n; i++)
            {
                sum += arr[j];
                if(Math.floor(Math.sqrt(sum)) == Math.ceil(Math.sqrt(sum)))
                    count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] out = new int[t];
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            out[i] = perfectSubarray(arr, n);
        }
        sc.close();
        for(int i = 1; i <= t; i++)
            System.out.println("Case #"+i+": "+out[i-1]);
    }
}*/


/*import java.util.*;
import java.io.*;

class solution
{
    public static int findCountDown(int[] arr, int n, int k)
    {
        int count = 0;
        int dec = 0;
        int i = 0;
        while(i < n)
        {
            if(arr[i] == k)
            {
                while(i < n && arr[i] == k-dec)
                {
                    i++;
                    dec++;
                }
                if(dec == k)
                    count++;
                dec = 0;
            }
            i++;
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] out = new int[t]; 
        for(int i = 0; i < t; i++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            out[i] = findCountDown(arr, n, k);
        }
        sc.close();
        for(int i = 1; i <= t; i++)
            System.out.println("Case #"+i+": "+out[i-1]);
    }
}*/


/*import java.util.Scanner;
class solution
{
    static String addParent(String str)
    {
        if(str.length() == 0)
            return str;
        StringBuilder s = new StringBuilder();
        int last = Character.getNumericValue(str.charAt(0));
        int count;
        if(last > 0)
        {
            count = last;
            while(count-- > 0)
                s.append('(');
        }
        s.append(last);
        for(int i = 1; i < str.length(); i++)
        {
            int x = Character.getNumericValue(str.charAt(i));
            if(last > x)
            {
                count = last - x;
                while(count-- > 0)
                 s.append(')');
            }
            else if(x > last)
            {
                count = x - last;
                while(count-- > 0)
                 s.append('(');
            }
            s.append(x);
            last = x;
        }
        if(last > 0)
        {
            count = last;
            while(count-- > 0)
                s.append(')');
        }
        return s.toString();
    }
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       sc = new Scanner(System.in);
       for(int i = 1; i <= t; i++)
       {
            String s = sc.nextLine();
            System.out.println("Case #"+i+": "+addParent(s));
       }
       sc.close();
    }
}*/