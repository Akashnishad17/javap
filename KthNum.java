import java.io.*;
import java.util.*;

class KthNum{

	public static int[][] seg; 

	public static void build(int[][] v, int index, int low, int high)
	{
		if(low == high)
		{
			seg[index] = new int[]{v[low][1]};
			return;
		}

		int mid = (low + high)/2;
		build(v, 2*index+1, low, mid);
		build(v, 2*index+2, mid+1, high);

		seg[index] = merge(2*index+1, 2*index+2);
	}

	public static int[] merge(int in1, int in2)
	{
		int l1 = seg[in1].length;
		int l2 = seg[in2].length;
		
		int[] res = new int[l1+l2];
		int i = 0, j = 0;

		while(i < l1 && j < l2)
		{
			if(seg[in1][i] < seg[in2][j])
			{
				res[i+j] = seg[in1][i];
				i++;
			}
			else
			{
				res[i+j] = seg[in2][j];
				j++;
			}
		}

		while(i < l1)
		{
			res[i+j] = seg[in1][i];
			i++;
		}

		while(j < l2)
		{
			res[i+j] = seg[in2][j];
			j++;
		}

		return res;
	}

	public static int query(int index, int low, int high, int l, int r, int k)
	{
		if(low == high)
			return seg[index][0];

		int mid = (low + high)/2;

		int last = upper(2*index+1, r) - seg[2*index+1][0];
		int first = lower(2*index+1, l) - seg[2*index+1][0];

		int m = last - first;
		if(m >= k)
			return query(2*index+1, low, mid, l, r, k);
		else
			return query(2*index+2, mid+1, high, l, r, k - m);
	}

	public static int upper(int in, int x)
	{
		int l = 0;
		int r = seg[in].length;
		int mid;
		
		while(l < r)
		{
			mid = l + (r - l)/2;
			
			if(seg[in][mid] <= x)
				l = mid + 1;
			else
				r = mid;
		}

		return l;
	}

	public static int lower(int in, int x)
	{
		int l = 0;
		int r = seg[in].length;
		int mid;
		
		while(l < r)
		{
			mid = l + (r - l)/2;

			if(seg[in][mid] >= x)
				r = mid;
			else
				l = mid + 1;
		}

		return l;
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int q = sc.nextInt();

		int[] arr = new int[n];
		int[][] v = new int[n][2];
		
		for(int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
			v[i][0] = arr[i];
			v[i][1] = i;
		}

		Arrays.sort(v, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b)
			{
				if(a[0] != b[0])
					return a[0] - b[0];
				return a[1] - b[1];
			}
		});

		seg = new int[3*n-1][];
		build(v, 0, 0, n-1);

		int x, y, k;

		while(q-- > 0)
		{
			x = sc.nextInt();
			y = sc.nextInt();
			k = sc.nextInt();

			System.out.println(arr[query(0, 0, n-1, x-1, y-1, k)]);
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input2.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
		{
			solve(sc);
		}
	}
}





/*
#include <bits/stdc++.h> 
using namespace std; 
  
void buildTree(int treeIndex, int l, int r, vector<pair<int, int> > &a, vector<int> tree[]) 
{ 
    if (l == r) { 
        tree[treeIndex].push_back(a[l].second); 
        return; 
    } 
  
    int mid = (l + r) / 2; 
  
    buildTree(2 * treeIndex, l, mid, a, tree); 
    buildTree(2 * treeIndex + 1, mid + 1, r, a, tree); 
  
    merge(tree[2 * treeIndex].begin(),  
          tree[2 * treeIndex].end(), 
          tree[2 * treeIndex + 1].begin(),  
          tree[2 * treeIndex + 1].end(), 
          back_inserter(tree[treeIndex])); 
} 
  
int queryRec(int segmentStart, int segmentEnd, int queryStart, int queryEnd, int treeIndex, int K, vector<int> tree[]) 
{ 
    if (segmentStart == segmentEnd)  
        return tree[treeIndex][0]; 
      
    int mid = (segmentStart + segmentEnd) / 2; 
  
    int last_in_query_range =  
            (upper_bound(tree[2 * treeIndex].begin(), 
                          tree[2 * treeIndex].end(), 
                                          queryEnd) 
                    - tree[2 * treeIndex].begin()); 
                    
    int first_in_query_range =  
                (lower_bound(tree[2 * treeIndex].begin(), 
                            tree[2 * treeIndex].end(), 
                                        queryStart) 
                          - tree[2 * treeIndex].begin()); 
  
    int M = last_in_query_range - first_in_query_range; 
  
    if (M >= K) { 
        return queryRec(segmentStart, mid, queryStart,  
                     queryEnd, 2 * treeIndex, K, tree); 
    } 
  
    else { 
        return queryRec(mid + 1, segmentEnd, queryStart, 
               queryEnd, 2 * treeIndex + 1, K - M, tree); 
    } 
} 
  
int query(int queryStart, int queryEnd, int K, int n, vector<pair<int, int> > &a, vector<int> tree[]) 
{ 
  
    return queryRec(0, n - 1, queryStart - 1, queryEnd - 1, 1, K, tree); 
} 
  
int main() 
{
	int n, q;
	cin>>n>>q;
    int arr[n];
    for(int i = 0; i < n; i++)
    	cin>>arr[i];

    vector<pair<int, int> > v; 
    for (int i = 0; i < n; i++) { 
        v.push_back(make_pair(arr[i], i)); 
    } 
  
    sort(v.begin(), v.end()); 
  
    vector<int> tree[3*n-1]; 
    buildTree(1, 0, n - 1, v, tree); 
  	
  	int l, r, k;
    while(q--){
    	cin>>l>>r>>k;
    	cout << arr[query(l, r, k, n, v, tree)] << endl; 
    }
  
    return 0; 
} */