#include <iostream>
using namespace std;

int main()
{
	int n, sum;
	cin >> n >> sum;
	
	int arr[n+1];
	for(int i = 1; i <= n; i++)
		cin >> arr[i];

	int dp[n+1][sum+1];

	for(int i = 1; i <= n; i++)
	{
		for(int s = 0; s <= sum; s++)
		{
			if(s == 0)
				dp[i][s] = 1;
			else
			{
				int d1 = i == 1 ? 0 : dp[i-1][s];
				int d2 = arr[i] > s ? 0 : dp[i][s - arr[i]];
				dp[i][s] = (d1 + d2) % 1000000007;
			}
		}
	}

	cout << dp[n][sum];
}