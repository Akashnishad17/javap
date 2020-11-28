#include <bits/stdc++.h>
using namespace std;

map <int, list<int> > my_map;

bool validToput(int dp[], int x, int y)
{
	if(dp[x] != 0 && dp[y] != 0)
		return !(dp[x] == dp[y]);

	if(dp[x] == 0 && dp[y] == 0)
	{
		dp[x] = 1;
		dp[y] = 2;
	}
	else if(dp[x] != 0)
		dp[y] = 3 ^ dp[x];
	else
		dp[x] = 3 ^ dp[y];

	return true;
}

bool dfs(int dp[], bool visited[], int x)
{
	list <int> :: iterator it;

	for(it = my_map[x].begin(); it != my_map[x].end(); it++)
	{
		if(!validToput(dp, x, *it))
			return false;

		if(!visited[*it])
		{
			visited[*it] = true;
			if(!dfs(dp, visited, *it))
				return false;
		}
	}

	return true;
}

int main()
{
	int n, m;
	cin >> n >> m;	

	int x, y;

	while(m--)
	{
		cin >> x >> y;
		
		my_map[x].push_back(y);
		my_map[y].push_back(x);
	}

	int dp[n+1];
	bool visited[n+1];

	for(int i = 1; i <= n; i++)
	{
		dp[i] = 0;
		visited[i] = false;
	}

	for(int i = 1; i <= n; i++)
	{
		if(dp[i] == 0)
		{
			visited[i] = true;

			if(my_map.find(i) == my_map.end())
				dp[i] = 1;
			else if(!dfs(dp, visited, i))
			{
				cout << "IMPOSSIBLE";
				return 0;
			}
		}
	}

	for(int i = 1; i <= n; i++)
		cout << dp[i] << " ";
}