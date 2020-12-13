#include <bits/stdc++.h>
using namespace std;

void solve()
{
    int n, x;
    cin >> n >> x;
    
    vector < queue<int> > ones;
    
    for(int i = 0; i < 31; i++)
        ones.push_back(queue<int>());
        
    int bin[n][31];
    int num;
    
    for(int i = 0; i < n; i++)
    {
        cin >> num;
        
        for(int j = 0; j < 31; j++)
        {
            if(num & (1 << (30 - j)))
			{
				bin[i][j] = 1;
				ones[j].push(i);
			}
			else
			    bin[i][j] = 0;
        }
    }
    
    for(int i = 0; i < n-1 && x > 0; i++)
	{
		for(int j = 0; j < 31 && x > 0; j++)
		{
			if(bin[i][j] == 1)
			{
				ones[j].pop();
				x--;
				bin[i][j] = 0;

				if(ones[j].empty())
					bin[n-1][j] ^= 1;
				else
				{
					bin[ones[j].front()][j] = 0;
					ones[j].pop();
				}
			}
		}
	}
	
	if(n == 2 && x % 2 != 0)
	{
		bin[n-2][30] = 1;
		bin[n-1][30] ^= 1;
	}
	
	for(int i = 0; i < n; i++)
	{
		num = 0;

		for(int j = 0; j < 31; j++)
		{
			if(bin[i][j] == 1)
				num += 1 << (30 - j);
		}

		cout << num << " ";
	}
	
	cout << endl;
    
}

int main()
{
    int t;
    cin >> t;
    
    while(t--)
    {
        solve();
    }
    return 0;
}
