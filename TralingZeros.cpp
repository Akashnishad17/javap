#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;

	int x = 5;
	int count = 0;

	while(x <= 1000000000)
	{
		count += n/x;
		x *= 5;
	}

	cout << count;
}