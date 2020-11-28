#include <bits/stdc++.h>
using namespace std;

int find(int parent[], int x)
{
	if(parent[x] == x)
		return parent[x];

	parent[x] = find(parent, parent[x]);

	return parent[x];
}

void unionSet(int parent[], int rank[], int x, int y)
{
	int p1 = find(parent, x);
	int p2 = find(parent, y);

	if(p1 == p2)
		return;

	if(rank[p1] > rank[p2])
	{
		parent[p2] = parent[p1];
		rank[p1] += rank[p2];
	}
	else
	{
		parent[p1] = parent[p2];
		rank[p2] += rank[p1];
	}
}

void solve()
{
	int n, m;
	cin >> n >> m;

	int parent[n+1], rank[n+1];

	for(int i = 1; i <= n; i++)
	{
		parent[i] = i;
		rank[i] = 1;
	}

	int x, y;
	while(m-- > 0)
	{
		cin >> x >> y;

		unionSet(parent, rank, x, y);
	}

	unordered_set <int> set;
	int res[n], count = 0;

	for(int i = 1; i <= n; i++)
	{
		parent[i] = find(parent, i);

		if(set.find(parent[i]) == set.end())
		{
			res[count++] = parent[i];
			set.insert(parent[i]);
		}
	}

	cout << (count - 1) << endl;
	
	for(int i = 1; i < count; i++)
		cout << res[i-1] << " " << res[i] << endl;

}

int main()
{
	solve();
} 