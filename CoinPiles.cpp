#include <iostream>
using namespace std;

int main()
{
	int t, a, b;

	cin >> t;
	
	while(t--)
	{
		cin >> a >> b;

		if(a*2 == b || b*2 == a || (a == b && a%3 == 0))
			cout << "YES";

		else if( a*2 < b || b*2 < a || a == 0 || b == 0)
			cout << "NO";

		else
		{
			int min = a < b ? a : b;
			int max = a > b ? a : b;

			if((2*min - max) % 3 == 0)
				cout << "YES";
			else
				cout << "NO";
		}

		cout << endl;
	}
}