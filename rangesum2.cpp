#include <bits/stdc++.h>
using namespace std;

long long seg[600000];

void build(long arr[], int index, int low, int high)
{
	if(low == high)
	{
		seg[index] = arr[low];
		return;
	}

	int mid = (low + high)/2;

	build(arr, 2*index+1, low, mid);
	build(arr, 2*index+2, mid+1, high);

	seg[index] = seg[2*index+1] + seg[2*index+2]; 
}

long query(int index, int low, int high, int l, int r)
{
	if(r < low || high < l)
		return 0;

	if(l <= low && high <= r)
		return seg[index];

	int mid = (low + high)/2;

	long left = query(2*index+1, low, mid, l, r);
	long right = query(2*index+2, mid+1, high, l, r);

	return left + right;
}

void update(int index, int low, int high, int k, long val)
{
    if(low == high)
    {
        seg[index] = val;
        return;
    }
    
    int mid = (low + high)/2;
    
    if(k <= mid)
        update(2*index+1, low, mid, k, val);
    else
        update(2*index+2, mid+1, high, k, val);
        
    seg[index] = seg[2*index+1] + seg[2*index+2];
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
		    cin >> x >> u;
		    update(0, 0, n-1, x-1, u);
		}
		else
		{
		    cin >> x >> y;
		    cout << query(0, 0, n-1, x-1, y-1) << endl;
		}
	}
}

int main()
{
	solve();
}