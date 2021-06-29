import java.io.*;
import java.util.*;

class Guess{
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, start, end, mid, num;
        String s;
        while(t-- > 0)
        {
            start = sc.nextInt();
            end = sc.nextInt();
            n = sc.nextInt();
            while(start <= end)
            {
                mid = (end-start)/2;
                System.out.println(mid);
                s = sc.next();
                if(s.equals("CORRECT"))
                    break;
                else if(s.equals("WRONG_ANSWER"))
                    return;
                else if(s.equals("TOO_SMALL"))
                    start = mid + 1;
                else if(s.equals("TOO_BIG"))
                    end = mid;
            }
        }
    }
}