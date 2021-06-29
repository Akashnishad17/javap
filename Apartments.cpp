#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m, k;

	cin >> n >> m >> k;

	int arr[n], app[m];

	int i, j;

	for(i = 0; i < n; i++)
		cin >> arr[i];

	for(j = 0; j < m; j++)
		cin >> app[j];

	sort(arr, arr+n);
	sort(app, app+m);

	i = 0; 
	j = 0;
	int count = 0;

	while(i < n && j < m)
	{
		if(app[j] - k <= arr[i] && arr[i] <= app[j] + k)
		{
			count++;
			i++;
			j++;
		}

		else if(app[j] - k > arr[i])
			i++;

		else if(app[j] + k < arr[i])
			j++;
	}

	cout << count;
}