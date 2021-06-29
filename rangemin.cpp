#include <bits/stdc++.h>
using namespace std;

int seg[600000];

void build(int arr[], int index, int low, int high)
{
	if(low == high)
	{
		seg[index] = arr[low];
		return;
	}

	int mid = (low + high)/2;

	build(arr, 2*index+1, low, mid);
	build(arr, 2*index+2, mid+1, high);

	seg[index] = min(seg[2*index+1], seg[2*index+2]); 
}

int query(int index, int low, int high, int l, int r)
{
	if(r < low || high < l)
		return 1000000007;

	if(l <= low && high <= r)
		return seg[index];

	int mid = (low + high)/2;

	int left = query(2*index+1, low, mid, l, r);
	int right = query(2*index+2, mid+1, high, l, r);

	return min(left, right);
}

void solve()
{
	int n, q;
	cin >> n >> q;
	int arr[n];

	for(int i = 0; i < n; i++)
		cin >> arr[i];

	build(arr, 0, 0, n-1);

	int l, r;
	while(q-- > 0)
	{
		cin >> l >> r;
		cout << query(0, 0, n-1, l-1, r-1) << endl;
	}
}

int main()
{
	solve();
}