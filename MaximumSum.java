import java.io.*;
import java.util.*;

class MaximumSum{
	public static int[] max;
	public static int[] secMax;
	
	public static void buildSegment(int[] arr, int index, int low, int high)
	{
		if(low == high)
		{
			max[index] = arr[low];
			secMax[index] = Integer.MIN_VALUE;
			return;
		}

		int mid = (low + high)/2;
		buildSegment(arr, 2*index+1, low, mid);
		buildSegment(arr, 2*index+2, mid+1, high);

		max[index] = Math.max(max[2*index+1], max[2*index+2]);
		secMax[index] = Math.max(Math.min(max[2*index+1], max[2*index+2]), Math.max(secMax[2*index+1], secMax[2*index+2]));
	}

	public static int[] query(int index, int low, int high, int l, int r)
	{
		if(l > high || r < low)
			return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

		if(low >= l && high <= r)
			return new int[]{max[index], secMax[index]};

		int mid = (low + high)/2;
		int[] left = query(2*index+1, low, mid, l, r);
		int[] right = query(2*index+2, mid+1, high, l, r);

		int m1 = Math.max(left[0], right[0]);
		int m2 = Math.max(Math.min(left[0], right[0]), Math.max(left[1], right[1]));
		return new int[]{m1, m2};
	}

	public static void update(int index, int low, int high, int in, int val)
	{
		if(low == high)
		{
			max[index] = val;
			return;
		}

		int mid = (low + high)/2;
		if(in <= mid)
			update(2*index+1, low, mid, in, val);
		else
			update(2*index+2, mid+1, high, in, val);

		max[index] = Math.max(max[2*index+1], max[2*index+2]);
		secMax[index] = Math.max(Math.min(max[2*index+1], max[2*index+2]), Math.max(secMax[2*index+1], secMax[2*index+2]));
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		max = new int[3*n-1];
		secMax = new int[3*n-1];

		buildSegment(arr, 0, 0, n-1);
		
		int q = sc.nextInt();
		char c;
		int x, y;
		int[] res;
		
		while(q-- > 0)
		{
			c = sc.next().charAt(0);
			x = sc.nextInt();
			y = sc.nextInt();

			if(c == 'Q')
			{
				res = query(0, 0, n-1, x-1, y-1);
				System.out.println(res[0]+res[1]);
			}
			else
				update(0, 0, n-1, x-1, y);
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		solve(sc);
	}
}


/*
#include<bits/stdc++.h>
using namespace std;

int *mx;
int *secmx;


  
    
    void buildSegment(int arr[], int index, int low, int high)
    {
        if(low == high)
        {
            mx[index] = arr[low];
            secmx[index] = INT_MIN;
            return;
        }
        int mid = (low + high)/2;
        buildSegment(arr, 2*index+1, low, mid);
        buildSegment(arr, 2*index+2, mid+1, high);
        mx[index] = std::max(mx[2*index+1], mx[2*index+2]);
        secmx[index] = std::max(std::min(mx[2*index+1], mx[2*index+2]), std::max(secmx[2*index+1], secmx[2*index+2]));
    }

    vector<int> query(int index, int low, int high, int l, int r)
    {
        vector<int> p;

        if(l > high || r < low){
            p.push_back(INT_MIN);
            p.push_back(INT_MIN);
            return p;}


        if(low >= l && high <= r){
        p.push_back(mx[index]);p.push_back(secmx[index]);
        return p;}

        int mid = (low + high)/2;
        vector<int> left,right;
        left = query(2*index+1, low, mid, l, r);
        right= query(2*index+2, mid+1, high, l, r);
        int m1 = std::max(left[0], right[0]);
        int m2 = std::max(std::min(left[0], right[0]), std::max(left[1], right[1]));
       p.push_back(m1);
       p.push_back(m2);
        return p;
    }

    void update(int index, int low, int high, int in, int val)
    {
        if(low == high)
        {
            mx[index] = val;
            return;
        }
        int mid = (low + high)/2;
        if(in <= mid)
            update(2*index+1, low, mid, in, val);
        else
            update(2*index+2, mid+1, high, in, val);
        mx[index] = std ::max(mx[2*index+1], mx[2*index+2]);
        secmx[index] = std::max(std::min(mx[2*index+1], mx[2*index+2]), std::max(secmx[2*index+1], secmx[2*index+2]));
    }

    void solve()
    {
        int n ;
        cin>>n;
        mx=new int[3*n-1];
        secmx = new int[3*n-1];

        int arr[n];

        for(int i = 0; i < n; i++)
            cin>>arr[i];

         
         
         buildSegment(arr, 0, 0, n-1);

            int q;
            cin>>q;

            char c;
            int x, y;
            vector<int> res;
        while(q-- > 0)
        {
            cin>>c;

            cin>>x;
            cin>>y;
            if(c == 'Q')
            {
                res = query(0, 0, n-1, x-1, y-1);
                cout<<res[0]+res[1]<<endl;
            }
            else
                update(0, 0, n-1, x-1, y);
        }
    }
    int main()
    {
        solve();
    }
*/