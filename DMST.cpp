#include <bits/stdc++.h>
using namespace std;

struct Edge{
	int src, des, dis;
};

struct Subset{
	int parent, rank;
};

int getDistance(int a[], int b[], int d)
{
	int dis = 0;
	for(int i = 0; i < d; i++)
		dis += abs(a[i]-b[i]);

	return dis;
}

bool cmp(Edge a, Edge b)
{
	return a.dis > b.dis;
}

int find(Subset sub[], int i)
{
	if(sub[i].parent != i)
		sub[i].parent = find(sub, sub[i].parent);
	return sub[i].parent;
}

void unionSet(Subset sub[], int x, int y)
{
	int p1 = find(sub, x);
	int p2 = find(sub, y);

	if(sub[p1].rank > sub[p2].rank)
	{
		sub[p2].parent = p1;
		sub[p1].rank += sub[p2].rank;
	}
	else
	{
		sub[p1].parent = p2;
		sub[p2].rank += sub[p1].rank;
	}
}

int main()
{
	int n, d;

	cin >> n >> d;

	int arr[n][d];

	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < d; j++)
			cin >> arr[i][j];
	}

	int total = (n * (n -1))/2;
	int in = 0;

	Edge edges[total];

	for(int i = 0; i < n-1; i++)
	{
		for(int j = i+1; j < n; j++)
		{
			edges[in].src = i;
			edges[in].des = j;
			edges[in].dis = getDistance(arr[i], arr[j], d);
			in++;
		}
	}

	sort(edges, edges+total, cmp);

	Subset sub[n];

	for(int i = 0; i < n; i++)
	{
		sub[i].parent = i;
		sub[i].rank = 1;
	}

	int i = 0, e = 0, cost = 0, x, y;

	while(e < n - 1)
	{
		x = find(sub, edges[i].src);
		y = find(sub, edges[i].des);

		if(x != y)
		{
			e++;
			cost += edges[i].dis;
			unionSet(sub, x, y);
		}

		i++;
	}

	cout << cost;
}