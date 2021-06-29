import java.io.*;
import java.util.*;
 
class EqualVector{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y = 0, z = 0;
        while(n-- > 0)
        {
            x += sc.nextInt();
            y += sc.nextInt();
            z += sc.nextInt();
        }
        String res = (x == 0 && y == 0 && z == 0) ? "YES" : "NO";
        System.out.print(res);
    }
}