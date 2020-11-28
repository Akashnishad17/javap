#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int res[100001];
int dp[101][100001];

void solve(int arr[], int index, int n, int sum)
{
	if(index == n)
	{
		res[sum] = 1;
		return;
	}

	if(dp[index][sum])
		return;

	solve(arr, index+1, n, sum);
	solve(arr, index+1, n, sum + arr[index]);

	dp[index][sum] = 1;
}

int main()
{
	int n;
	cin >> n;

	int arr[n];
	for(int i = 0; i < n; i++)
		cin >> arr[i];

	sort(arr, arr+n);

	for(int i = 0; i <= 100000; i++)
		res[i] = 0;

	for(int i = 0; i <= 100; i++)
	{
		for(int j = 0; j <= 100000; j++)
			dp[i][j] = 0;
	}

	solve(arr, 0, n, 0);

	int count = 0;
	for(int i = 1; i <= 100000; i++)
	{
		if(res[i] == 1)
			count++;
	}

	cout << count << endl;

	for(int i = 1; i <= 100000; i++)
	{
		if(res[i] == 1)
			cout << i << " ";
	}
}