#include <iostream>
using namespace std;

int main()
{
	int n, sum;
	cin >> n >> sum;
	int price[n+1], pages[n+1];

	for(int i = 1; i <= n; i++)
		cin >> price[i];

	for(int i = 1; i <= n; i++)
		cin >> pages[i];

	int dp[n+1][sum+1];

	for(int i = 0; i <= n; i++)
	{
		for(int s = 0; s <= sum; s++)
		{
			if(i == 0 || s == 0)
				dp[i][s] = 0;
			else
			{
				int d1 = i == 1 ? 0 : dp[i-1][s];
				int d2 = price[i] > s ? 0 : pages[i] + dp[i-1][s - price[i]];
				dp[i][s] = max(d1,d2);
			}
		}
	}

	cout << dp[n][sum];
}