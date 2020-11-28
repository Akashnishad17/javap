#include <bits/stdc++.h>
using namespace std;

map < int, list<int> > my_map;
int res = 0;

int dfs(int node, bool visited[])
{
    list <int> :: iterator it;
    
    int max1 = -1, max2 = -1, temp;
    
    visited[node] = true;
    
    for(it = my_map[node].begin(); it != my_map[node].end(); it++)
    {
        if(!visited[*it])
        {
            temp = dfs(*it, visited);
            
            if(max1 == -1)
				max1 = temp;

			else
			{
				if(temp > max1)
				{
					max2 = max1;
					max1 = temp;
				}
				else
					max2 = max(max2, temp);
			}
        }
    }
    
    visited[node] = false;
        
    if(max1 == -1 && max2 == -1)
		return 1;

	if(max2 == -1)
	{
		res = max(res, max1);
		return 1 + max1;
	}

	res = max(res, max1+max2);
	return 1 + max(max1, max2);
}

int main()
{
    int n;
    
    cin >> n;
    
    if(n == 1)
    {
        cout << 0;
        return 0;
    }
    
    int x, y;
    
    for(int i = 1; i < n; i++)
    {
        cin >> x >> y;
        
        my_map[x].push_back(y);
        my_map[y].push_back(x);
    }
    
    bool visited[n+1];
    
    for(int i = 1; i <= n; i++)
        visited[i] = false;
    
    dfs(1, visited);
    
    cout << res;
}