import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxJoy {
    static class Max_comp implements Comparator<Integer>{
        public int compare(Integer x, Integer y)
        {
            if((int)x < (int)y)
                return 1;
            else
                return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        PriorityQueue<Integer> blue = new PriorityQueue<Integer>(new Max_comp());
        PriorityQueue<Integer> yellow = new PriorityQueue<Integer>(new Max_comp());
        PriorityQueue<Integer> colorless = new PriorityQueue<Integer>(new Max_comp());
        for(int i = 0; i < x; i++)
            blue.add(sc.nextInt());
        for(int i = 0; i < y; i++)
            yellow.add(sc.nextInt());
        for(int i = 0; i < z; i++)
            colorless.add(sc.nextInt());
        long max = 0;
        while(n > 0 || m > 0)
        {
            int b = blue.size() > 0 ? blue.peek() : 0;
            int t = yellow.size() > 0 ? yellow.peek() : 0;
            int c = colorless.size() > 0 ? colorless.peek() : 0;
            if(c == 0)
            {
                if(n > 0 && m > 0)
                {
                    if(Math.max(b,t) == b)
                    {
                        max += blue.poll();
                        n--;
                    }
                    else
                    {
                        max += yellow.poll();
                        m--;
                    }
                }
                else if(n > 0)
                {
                    max += blue.poll();
                    n--;
                }
                else if(m > 0)
                {
                    max += yellow.poll();
                    m--;
                }
            }
            else
            {
                if(n > 0 && m > 0)
                {
                    int current_max = Math.max(Math.max(b,t),c);
                    if(current_max == b)
                    {
                        max += blue.poll();
                        n--;
                    }
                    else if(current_max == t)
                    {
                        max += yellow.poll();
                        m--;
                    }
                    else
                    {
                        max += colorless.poll();
                        if(Math.max(b,t) == b)
                            m--; 
                        else
                            n--;
                    }

                }
                else if(n > 0)
                {
                    if(Math.max(b,c) == b)
                        max += blue.poll();
                    else
                        max += colorless.poll();
                    n--;
                }
                else if(m > 0)
                {
                    if(Math.max(t,c) == t)
                        max += yellow.poll();
                    else
                        max += colorless.poll();
                    m--;
                }
            }
        }
        System.out.print(max);
    }
}

/*
        while(n -- > 0)
        {
            int b = blue.size() > 0 ? blue.peek() : 0;
            int c = colorless.size() > 0 ? colorless.peek() : 0;
            if(b != 0 && c != 0)
            {
                if(b >= c)
                    max += blue.poll();
                else
                    max += colorless.poll();
            }
            else if(b != 0)
                max += blue.poll();
            else if(c != 0)
                max += colorless.poll();
        }
        while(m -- > 0)
        {
            int t = yellow.size() > 0 ? yellow.peek() : 0;
            int c = colorless.size() > 0 ? colorless.peek() : 0;
            if(t != 0 && c != 0)
            {
                if(t >= c)
                    max += yellow.poll();
                else
                    max += colorless.poll();
            }
            else if(t != 0)
                max += yellow.poll();
            else if(c != 0)
                max += colorless.poll();
        }
*/