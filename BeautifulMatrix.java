import java.io.*;
import java.util.*;

class BeautifulMatrix{
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0, s;
        for(int i = 1; i <= 5; i++)
        {
            for(int j = 1; j <= 5; j++)
            {
                s = sc.nextInt();
                if(s == 1)
                {
                    x = i;
                    y = j;
                }
            }
        }
        int res = (int)Math.abs(x-3) + (int)Math.abs(y-3);
        System.out.print(res);
    }
}