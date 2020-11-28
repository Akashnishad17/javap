/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ChefSwap
{
    public static long getIndex(long n, long sum)
    {
        long l = 1;
        long r = n;
        long mid;
        long range;
        long diff;
        while(l < r)
        {
            mid = l + (r-l)/2;
            range = (mid*(mid+1))/2;
            diff = sum - range;
            if(diff+1 == n)
            	return mid-1;
            else if(diff+1 > n)
            	l = mid+1;
            else
            	r = mid-1;
        }
        return r-1;
    }

    public static long getSumBy2Index(long r, long sum)
    {
    	long l = 1;
    	long mid;
    	long range;
    	while(l < r)
    	{
    		mid = l + (r-l)/2;
    		range = (mid*(mid+1))/2;
    		if(range == sum)
    			return mid;
    		else if(range > sum)
    			r = mid - 1;
    		else
    			l = mid + 1;
    	}
    	range = l*(l+1)/2;
    	if(range > sum)
    		l--;
    	return l;
    } 

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    long n = sc.nextLong();
		    long sum = (n*(n+1))/2;
		    if(sum % 2 != 0)
		    {
		        System.out.println(0);
		        continue;
		    }
		    long right = getSumBy2Index(n, sum/2);
		    long i = getIndex(right, sum/2);
		    long range = (i*(i+1))/2;
		    long count = 0;
		    while(i <= right)
		    {
		        if(range == sum/2)
		        {
		            long j = n - i;
		            count += (i*(i-1))/2 + (j*(j-1))/2;
		        }
		        else
		        {
		            long diff = sum/2 - range;
		            long l2 = i + 1;
		            long l1 = l2 - diff;
		            long k = l1; 
		            if(k <= 0)
		            {
		                l1 += (1 - k);
		                l2 += (1 - k);
		            }
		            if(l2 <= n)
		            {
		                long min = i - l1 + 1;
		                if(n - l2 + 1 < min)
		                    min = n - l2 + 1;
		                count += min;
		            }
		        }
		        range += ++i;
		    }
		    System.out.println(count);
		}
	}
}
