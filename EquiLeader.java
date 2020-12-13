// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class EquiLeader {
    public int solution(int[] A) {
        
        int n = A.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int val = 1000000001;
        int freq;

        for(int i = 0; i < n; i++)
        {
            freq = map.getOrDefault(A[i], 0) + 1;
            map.put(A[i], freq);
            
            if(freq > max)
            {
                max = freq;
                val = A[i];
            }

            if(max > (i+1)/2)
                prefix[i] = val;
            else
                prefix[i] = 1000000001;
        }

        map.clear();
        max = 0;
        val = 1000000001;

        for(int i = n-1; i >= 0; i--)
        {
            freq = map.getOrDefault(A[i], 0) + 1;
            map.put(A[i], freq);
            
            if(freq > max)
            {
                max = freq;
                val = A[i];
            }

            if(max > (n - i)/2)
                suffix[i] = val;
            else
                suffix[i] = 1000000001;
        }

        int count = 0;

        for(int i = 0; i < n-1; i++)
        {
            if(prefix[i] == 1000000001 || suffix[i+1] == 1000000001)
                continue;

            if(prefix[i] == suffix[i+1])
                count++;
        }

        return count;
    }
}
