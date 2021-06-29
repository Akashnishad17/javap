import java.io.*;
import java.util.*;


public class Akshat {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input6.txt"));   System.setOut(new PrintStream(new File("output.txt")));
         int N = Integer.parseInt(br.readLine().trim());
         int[][] Query = new int[N][3];
         for(int i_Query = 0; i_Query < N; i_Query++)
         {
         	String[] arr_Query = br.readLine().split(" ");
         	for(int j_Query = 0; j_Query < arr_Query.length; j_Query++)
         	{
         		Query[i_Query][j_Query] = Integer.parseInt(arr_Query[j_Query]);
         	}
         }

         int  out_ = find_knowledge(Query,N);
         System.out.println(out_);
    }
    public static int[] seg;
    public static void build(int[][] arr , int index, int low, int high){
            if(low == high){
                seg[index] = arr[low][2];
                return;
            }

            int mid = low +(high-low)/2;

            build(arr,2*index+1,low,mid);
            build(arr,2*index+2,mid+1,high);

            seg[index] = Math.max(seg[2*index+1],seg[2*index+2]);
        
    }

    public static int query(int index,int low ,int high ,int l ,int r){
        if(r < low || high < l)
            return 0;

        if(l <=low && high<=r)
        return seg[index];

        int mid = low+ (high -low)/2;

        int left = query(2*index+1,low,mid,l,r);
        int right = query(2*index+2,mid+1,high,l,r);

        return Math.max(left,right);

    }
    public static int lowerBound(int[][] arr , int l ,int r,long x){
            {
                int mid = r;
                while(l < r){
                    mid = l + (r-l)/2;
                    if(arr[mid][0]>x)
                        r = mid;
                    else
                        l = mid+1;
                }
                return r;
            }
    }
    static int find_knowledge(int[][] arr,int n){
       seg = new int[4*n];
       Arrays.sort(arr,(a,b)-> a[0] == b[0] ? a[1]-b[1]:a[0]-b[0]);
       build(arr, 0, 0, n-1);
       int max=0;

       for(int i =0 ;i<n-1;i++){
           int index=lowerBound(arr,i+1,n,arr[i][1]);
       

       if(index!=n){
           int temp =query(0,0,n-1,index,n-1);
           max= Math.max(max,temp+arr[i][2]);
       }
       }
       
        return max;
    }
}