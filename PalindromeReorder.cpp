#include <iostream>
#include <string.h>
using namespace std;

int main()
{
	string s;

	cin >> s;

	int dp[26];
	for(int i = 0; i < 26; i++)
		dp[i] = 0;

	for(int i = 0; i < s.length(); i++)
		dp[s.at(i) - 'A']++;

	int odd = 0;
	int oddIndex = -1;
	for(int i = 0; i < 26; i++)
	{
		if(dp[i] % 2 != 0)
		{
			odd++;
			oddIndex = i;
		}
	}

	if(odd > 1)
	{
		cout << "NO SOLUTION";
		return 0;
	}

	string res1 = "";
	string res2 = "";
	int count;

	for(int i = 0; i < 26; i++)
	{
		if(dp[i] % 2 == 0)
		{
			count = dp[i]/2;
			while(count-- > 0)
				res1.push_back((char)(i + 'A'));
		}
	}

	for(int i = res1.length()-1; i >= 0; i--)
		res2.push_back(res1.at(i));

	if(oddIndex != -1)
	{
		while(dp[oddIndex]-- > 0)
			res1.push_back((char)(oddIndex + 'A'));
	}

	cout << res1 << "" << res2;
}