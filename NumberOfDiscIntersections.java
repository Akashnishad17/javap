import java.util.*;
import java.io.*;

class NumberOfDiscIntersections {

    private int upperBound(long[][] arr, int l, int r, long x)
    {
        int mid;

        while(r - l > 1)
        {
            mid = l + (r - l)/2;

            if(arr[mid][0] > x)
                r = mid - 1;
            else
                l = mid;
        }

        return arr[r][0] > x ? l : r;
    }

    public int solution(int[] A) {
        
        int n = A.length;
        long[][] arr = new long[n][2];

        for(int i = 0; i < n; i++)
        {
            arr[i][0] = i - (long)A[i];
            arr[i][1] = i + (long)A[i]; 
        }

        Arrays.sort(arr, (a, b) -> 
            a[0] == b[0] ? (a[1] > b[1] ? 1 : -1) 
            : (a[0] > b[0] ? 1 : -1)
        );

        int count = 0;

        for(int i = 0; i < n; i++)
        {
            count += upperBound(arr, i, n-1, arr[i][1]) - i;
            if(count > 10000000)
                return -1;
        }

        return count;
    }
}
