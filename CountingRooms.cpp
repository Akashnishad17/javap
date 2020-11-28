#include <bits/stdc++.h>
using namespace std;

char grid[1000][1000];
bool visited[1000][1000];

void dfs(int n, int m, int i, int j)
{
	if(i < 0 || j < 0 || i == n || j == m || visited[i][j] || grid[i][j] == '#')
		return;

	visited[i][j] = true;

	dfs(n, m, i+1, j);
	dfs(n, m, i-1, j);
	dfs(n, m, i, j+1);
	dfs(n, m, i, j-1);
}

int main()
{
	int n, m;
	cin >> n >> m;

	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			cin >> grid[i][j];
			visited[i][j] = false;
		}
	}

	int count = 0;

	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			if(!visited[i][j] && grid[i][j] == '.')
			{
				count++;
				dfs(n, m, i, j);
			}
		}
	}

	cout << count;
}