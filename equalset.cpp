#include <iostream>
using namespace std;

void solve(int n)
{
	if(n % 4 == 1 || n % 4 == 2)
	{
		cout << "NO";
		return;
	}
	else
		cout << "YES" << endl;

	int set1 = (n / 4) * 2 + (n % 4 == 0 ? 0 : 2);
	int set2 = n - set1;

	cout << set1 << endl;

	if(n % 4 == 0)
	{
		for(int i = 1; i <= n; i += 4)
			cout << i << " " << (i+3) << " ";
	}
	else
	{
		cout << "1 2 ";
		for(int i = 4; i <= n; i += 4)
			cout << i << " " << (i+3) << " ";
	}

	cout << endl << set2 << endl;

	if(n % 4 == 0)
	{
		for(int i = 2; i <= n; i += 4)
			cout << i << " " << (i+1) << " ";
	}
	else
	{
		cout << "3 ";
		for(int i = 5; i <= n; i += 4)
			cout << i << " " << (i+1) << " ";
	}

}

int main()
{
	int n;
	cin >> n;
	solve(n);
}