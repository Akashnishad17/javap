#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	cin >> t;

	while(t-- > 0)
	{
		int n;
		cin >> n;

		int arr[n+1];

		for(int i = 1; i <= n; i++)
			cin >> arr[i];

		int count = 1;

		for(int i = n; i > 0; i--)
		{
			if(arr[i] == i)
				arr[i] = count++;
			else if(arr[i] > i)
				arr[i] = arr[arr[i]];
		}

		for(int i = 1; i <= n; i++)
			cout << arr[i] << " ";;

		cout << endl;
	}

	return 0;
}