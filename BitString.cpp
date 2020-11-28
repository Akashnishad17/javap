#include <iostream>
using namespace std;

long long solve(long long n)
{
	long long res = 1;

	while(n-- > 0)
		res = (2 * res) % 1000000007;

	return res;
}

int main()
{
	long long n;
	cin >> n;

	cout << solve(n);
}