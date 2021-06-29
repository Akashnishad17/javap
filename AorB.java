import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class AorB {

    static void fillHexa(int[] arr, int index, int val)
    {
        while(val > 0)
        {
            arr[index--] = val%2;
            val /= 2;
        }
    }

    static int[] convertToArray(String s)
    {
        int n = 8;
        int[] arr = new int[n];

        int index = n-1;
        int x;
        
        for(int i = s.length()-1; i >= 0; i--)
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                x = s.charAt(i) - '0';
            else
                x = s.charAt(i) - 'A' + 10;
            
            fillHexa(arr, index, x);
            index -= 4;
        }

        return arr;
    }

    static String convertToHexa(int[] arr)
    {
        String res = "";
        int x;
        char c;
        for(int i = 0; i < arr.length; i += 4)
        {
            x = arr[i]*8 + arr[i+1]*4 + arr[i+2]*2 + arr[i+3];
            if(x < 10)
                c = (char)(x + '0');
            else
                c = (char)(x - 10 + 'A');

            if(c == '0')
            {
                if(res.length() > 0)
                    res += c;
            }
            else
                res += c;
        }

        if(res.length() == 0)
            res = "0";

        return res;
    }

    static void aOrB(int k, String a, String b, String c) {
        int[] A = convertToArray(a);
        int[] B = convertToArray(b);
        int[] C = convertToArray(c);

        List<Integer> certain = new ArrayList<>();

        for(int i = 0; i < 8; i++)
        {
            if(C[i] == 0)
            {
                if(A[i] == 1)
                {
                    A[i] = 0;
                    k--;
                }

                if(B[i] == 1)
                {
                    B[i] = 0;
                    k--;
                }
            }

            else
            {
                if(A[i] == 0 && B[i] == 0)
                {
                    B[i] = 1;
                    k--;
                }

                if(A[i] == 1)
                    certain.add(i);
            }

            if(k < 0)
            {
                System.out.println(-1);
                return;
            }
        }

        for(int i = 0; i < certain.size() && k > 0; i++)
        {
            if(B[certain.get(i)] == 0)
            {
                if(k > 1)
                {
                    k -= 2;
                    A[certain.get(i)] = 0;
                    B[certain.get(i)] = 1;
                }
            }
            else
            {
                A[certain.get(i)] = 0;
                k--;
            }
        }

        a = convertToHexa(A);
        b = convertToHexa(B);

        System.out.println(a);
        System.out.println(b);
    }


    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("input6.txt"));
        System.setOut(new PrintStream(new File("output.txt")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int k = Integer.parseInt(scanner.nextLine().trim());

            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String c = scanner.nextLine();

            aOrB(k, a, b, c);
        }
    }
}
