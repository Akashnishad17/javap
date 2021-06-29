#include <iostream>
using namespace std;

int main()
{
	int t;
	cin >> t;
	long long x, y, res;

	while(t--)
	{
		cin >> x >> y;

		if(x == y)
			res = 1 + x * (x -1);

		else if(x < y)
		{
			if(y % 2 == 0)
				res = (y - 1) * (y - 1) + x;
			else
				res = y * y - x + 1;
		}

		else
		{
			if(x % 2 == 0)
				res = x * x - y + 1;
			else
				res = (x - 1) * (x - 1) + y;
		}

		cout << res << endl;
	}
}