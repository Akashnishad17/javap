import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Triplet {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long[] dp1 = new long[arr.size()];
        HashMap<Long,Integer> map1 = new HashMap<>();
        for(int i = 0; i < arr.size()-1; i++)
        {
            if(Math.ceil(((double)arr.get(i))/r) == Math.floor(((double)arr.get(i))/r))
                dp1[i] = map1.getOrDefault(arr.get(i)/r, 0);
            map1.put(arr.get(i), map1.getOrDefault(arr.get(i), 0) + 1);
        }
        long[] dp2 = new long[arr.size()];
        HashMap<Long,Integer> map2 = new HashMap<>();
        for(int i = arr.size()-1; i > 0; i--)
        {
            dp2[i] = map2.getOrDefault(arr.get(i)*r, 0);
            map2.put(arr.get(i), map2.getOrDefault(arr.get(i), 0) + 1);
        }
        long count = 0;
        for(int i = 0; i < arr.size(); i++)
            count += dp1[i]*dp2[i];
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long r = sc.nextLong();
        List<Long> arr = new ArrayList<>();
        while(n-- > 0)
            arr.add(sc.nextLong());
        long ans = countTriplets(arr, r);
        System.out.print(ans);
    }
}
