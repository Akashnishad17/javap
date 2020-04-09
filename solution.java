import java.util.Scanner;
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
}