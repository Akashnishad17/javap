#include <bits/stdc++.h>
using namespace std;

long seg[600000][2];

void build(long arr[], int index, int low, int high)
{
	if(low == high)
	{
		seg[index][0] = arr[low];
		seg[index][1] = 0;
		return;
	}

	int mid = (low + high)/2;

	build(arr, 2*index+1, low, mid);
	build(arr, 2*index+2, mid+1, high);

	seg[index][0] = seg[2*index+1][0] + seg[2*index+2][0]; 
	seg[index][1] = 0;
}

long query(int index, int low, int high, int k)
{
    if(seg[index][1] > 0)
	{
		seg[index][0] += (high-low+1)*seg[index][1];
		
		if(low < high)
		{
			seg[2*index+1][1] += seg[index][1];
			seg[2*index+2][1] += seg[index][1];
		}

		seg[index][1] = 0;
	}
    
	if(low == high)
	    return seg[index][0];

	int mid = (low + high)/2;

    long res;
    
    if(k <= mid)
	    res = query(2*index+1, low, mid, k);
	else
	    res = query(2*index+2, mid+1, high, k);

	return res;
}

void update(int index, int low, int high, int l, int r, long val)
{
    if(seg[index][1] > 0)
	{
		seg[index][0] += (high-low+1)*seg[index][1];
		
		if(low < high)
		{
			seg[2*index+1][1] += seg[index][1];
			seg[2*index+2][1] += seg[index][1];
		}

		seg[index][1] = 0;
	}
    
    
    if(r < low || high < l || low > high)
        return;
        
    if(low >= l && high <= r)
	{
		seg[index][0] += (high-low+1)*val;

		if(low < high)
		{
			seg[2*index+1][1] += val;
			seg[2*index+2][1] += val;
		}
		return;
	}
    
    int mid = (low + high)/2;
    
    update(2*index+1, low, mid, l, r, val);
    update(2*index+2, mid+1, high, l, r, val);
        
    seg[index][0] = seg[2*index+1][0] + seg[2*index+2][0];
}

void solve()
{
	int n, q;
	cin >> n >> q;
	long arr[n];

	for(int i = 0; i < n; i++)
		cin >> arr[i];

	build(arr, 0, 0, n-1);

	int k, x, y;
	long u;
	while(q-- > 0)
	{
		cin >> k;
		if(k == 1)
		{
		    cin >> x >> y >> u;
		    update(0, 0, n-1, x-1, y-1, u);
		}
		else
		{
		    cin >> x;
		    cout << query(0, 0, n-1, x-1) << endl;
		}
	}
}

int main()
{
	solve();
}