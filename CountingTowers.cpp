#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t, n;
	cin >> t;

	int mod = 1000000007;

	while(t--)
	{
		cin >> n;

		long dp[n][2];

		dp[0][0] = 1;
		dp[0][1] = 1;

		for(int i = 1; i < n; i++)
		{
			dp[i][0] = (dp[i-1][1] + 2 * dp[i-1][0]) % mod;
			dp[i][1] = (dp[i-1][0] + 4 * dp[i-1][1]) % mod;
		}

		cout << (dp[n-1][0] + dp[n-1][1]) % mod << endl;
	}

	return 0;
}