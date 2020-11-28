#include <bits/stdc++.h>
using namespace std;

int getIndex(int arr[], int dp[], int l, int r, int x)
{
	int mid;

	while(r - l > 1)
	{
		mid = l + (r - l)/2;

		if(arr[mid] > x)
			r = mid - 1;

		else if(arr[mid] == x)
		{
			if(dp[mid] == 0)
				r = mid;
			else
				r = mid - 1;
		}

		else
		{
			if(dp[mid] == 0)
				l = mid;
			else
				l = mid + 1;
		}
	}

	if(dp[l] == 1 && dp[r] == 1)
		return -1;
		
	if(arr[l] > x)
	    return -1;

	if(arr[r] > x)
		return dp[l] == 0 ? l : -1;

	return dp[r] == 0 ? r : (dp[l] == 0 ? l : -1);
}

int main()
{
	int n, m;

	cin >> n >> m;

	int arr[n], dp[n];

	for(int i = 0; i < n; i++)
	{
		cin >> arr[i];
		dp[i] = 0;
	}

	sort(arr, arr+n);

	int x, index, l = 0, r = n-1;
	while(m--)
	{
		cin >> x;
		index = l > r ? -1 : getIndex(arr, dp, l, r, x);

		if(index == -1)
			cout << -1 << endl;

		else
		{
			cout << arr[index] << endl;
			dp[index] = 1;
			
			/*if(index == l)
			    l++;
			   
			else if(index == r)
			    r--;*/
		}
	}
}