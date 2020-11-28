#include <bits/stdc++.h>
using namespace std;

struct Task{
	int start, end;
};

bool cmp(Task a, Task b)
{
	return a.end < b.end;
}

int main()
{
	int n;

	cin >> n;

	Task arr[n];

	for(int i = 0; i < n; i++)
		cin >> arr[i].start >> arr[i].end;

	sort(arr, arr+n, cmp);
	int count = 1;
	int last = arr[0].end;

	for(int i = 1; i < n; i++)
	{
	    if(arr[i].start >= last)
	    {
	        count++;
	        last = arr[i].end;
	    }
	}

	cout << count;
}