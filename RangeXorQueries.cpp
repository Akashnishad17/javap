#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, q;

	cin >> n >> q;

	int arr[n+1];
	arr[0] = 0;

	int x;

	for(int i = 1; i <= n; i++)
	{
		cin >> x;
		arr[i] = x ^ arr[i-1];
	}

	int l, r;

	while(q--)
	{
		cin >> l >> r;
		cout << (arr[r] ^ arr[l-1]) << endl;
	}
}