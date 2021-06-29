#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int dp[1000001];

int solve(int arr[], int n, int sum)
{
	if(sum == 0)
		return 0;

	if(dp[sum] != -2)
		return dp[sum];

	int res = -1, temp;
	int i = 0;
	while(i < n && arr[i] <= sum)
	{
		if(dp[sum-arr[i]] == -2)
			dp[sum-arr[i]] = solve(arr, n, sum - arr[i]);

		temp = dp[sum-arr[i]];

		if(temp != -1)
		{
			if(res == -1)
				res = temp + 1;
			else if(temp + 1 < res)
				res = temp + 1;
		}
		i++;
	}

	return dp[sum] = res;
}

int main()
{
	int n, sum;
	cin >> n >> sum;

	int arr[n];
	for(int i = 0; i < n; i++)
		cin >> arr[i];

	sort(arr, arr+n);
	for(int i = 0; i <= 1000000; i++)
		dp[i] = -2;

	cout << solve(arr, n, sum);
}
