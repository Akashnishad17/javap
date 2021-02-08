#include <bits/stdc++.h>

using namespace std;

int dp[1001][1001];


int dfs(int arr[], int n, int index, int total, int taken, int empty, int x, int y, int *prefix)
{
	if(x <= total && total <= y)
		return prefix[taken-1];

	if(index == n || total > y)
		return -1;

	if(dp[taken][total] != -2)
		return dp[taken][total];

	int min1 = -1, min2 = -1;

	if(arr[index] <= y)
	{
		prefix[index] = empty;
		min1 = dfs(arr, n, index + 1, total + arr[index], taken+1, empty, x, y, prefix);
	}


	prefix[index] = empty + 1;
	min2 = dfs(arr, n, index + 1, total, taken, empty+1, x, y, prefix);

	int res = -1;

	if(min1 == -1 && min2 == -1)
		res = -1;

	else if(min1 == -1)
		res = min2;

	else if(min2 == -1)
		res = min1;

	else
		res = min(min1, min2);

	return dp[taken][total] = res;
}


void solve()
{
    int n, x, y;
    cin >> n >> x >> y;
    
    int arr[n];
    
    for(int i = 0; i < n; i++)
        cin >> arr[i];
        
    memset(dp, -2, sizeof(dp));
    
    
    int prefix[n+1];
    
    int empty = 0;

	while(empty < n && arr[empty] > y)
	{
		prefix[empty] = empty + 1;
		empty++;
	}

	while(n - 1 > empty && arr[n-1] > y)
		n--;

	cout << dfs(arr, n, empty, 0, 0, empty, x, y, prefix) << endl;
}

int main()
{
    int t;
    cin >> t;
    
    while(t--)
    {
        solve();
    }
    
    return 0;
}







