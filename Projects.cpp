#include <iostream>
#include <bits/stdc++.h>
using namespace std;

struct project{
	int s, e, price;
};

bool cmp(project& a, project& b)
{
	return a.e < b.e;
}

int lowerBound(vector<project>& v, int start, int r)
{
	int l = 0;
	int mid;
	while(r - l > 1)
	{
		mid = l + (r - l)/2;
		if(v[mid].e < start)
			l = mid;
		else
			r = mid;
	}
	return l;
}

int main()
{
	int n;
	cin >> n;

	vector<project> v(n+1);

	for(int i = 1; i <= n; i++)
		cin >> v[i].s >> v[i].e >> v[i].price;

	sort(v.begin() + 1, v.end(), cmp);

	long dp[n+1];
	long d1, d2;
	dp[0] = 0;

	for(int i = 1; i <= n; i++)
	{
		d1 = dp[i-1];
		d2 = v[i].price + dp[lowerBound(v, v[i].s, i)];
		dp[i] = d1 > d2 ? d1 : d2;
	}

	cout << dp[n];
}
