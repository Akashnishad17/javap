#include <bits/stdc++.h>
using namespace std;

struct Point{
	int val, cor;
};

bool cmp(Point a, Point b)
{
	if(a.val != b.val)
		return a.val < b.val;
	return a.cor < b.cor;
}

int main()
{
	int n;

	cin >> n;

	Point arr[2*n];

	for(int i = 0; i < n; i++)
	{
		cin >> arr[2*i].val >> arr[2*i+1].val;
		arr[2*i].cor = 0;
		arr[2*i+1].cor = 1;
	}

	sort(arr, arr+2*n, cmp);
	int max = 0, count = 0;

	for(int i = 0; i < 2*n; i++)
	{
		if(arr[i].cor == 0)
			count++;
		else
			count--;

		if(count > max)
		    max = count;
	}

	cout << max;
}