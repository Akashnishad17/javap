/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int[] A = new int[n];
		    int[] B = new int[n];
		    int xor = 0;
		    for(int i = 0; i < n; i++)
		    {
		        A[i] = sc.nextInt();
		        xor ^= A[i];
		    }
		    for(int i = 0; i < n; i++)
		    {
		        B[i] = sc.nextInt();
		        xor ^= B[i];
		    }
		    if(xor != 0)
		    {
		        System.out.println(-1);
		        continue;
		    }
		    
		}
	}
}