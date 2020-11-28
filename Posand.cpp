#include <iostream>
#include<bits/stdc++.h>
using namespace std;

bool isPowerof2(int n)
{
   return (ceil(log2(n)) == floor(log2(n)));
}

void solve(int n)
{
	if(n == 1)
	{
	    cout << "1" << endl;
		return;
	}

	if(n == 3)
	{
	    cout << "1 3 2" << endl;
		return;
	}

	if(n == 5)
	{
	    cout << "4 5 1 3 2" << endl;
		return;
	}
	
	if(isPowerof2(n))
	{
	    cout << "-1" << endl;
	    return;
	}

	
	cout << "4 5 1 3 2 ";

	int next = 6;
	int pow = 8;
	
	for(int i = 5; i < n; i++)
	{
		if(next == pow)
		{
			cout << (next+1) << " " << next << " ";
			pow *= 2;
			i++;
			next++;
		}
		else
		    cout << next << " ";
		next++;
	}

	cout << endl;
}

int main()
{
	int t, n;

	cin >> t;

	while(t--)
	{
		cin >> n;
		solve(n);
	}
}