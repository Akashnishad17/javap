#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, q;
    
    cin >> n >> q;
    
    int tree[n+1];
    tree[0] = 0;
    tree[1] = 0;
     
    int x;
    for(int i = 2; i <= n; i++)
    {
        cin >> x;
        tree[i] = x;
    }
    
    int k;
    
    while(q-- > 0)
    {
        cin >> x >> k;
        
        while(k-- > 0 && x > 0)
            x = tree[x];
            
        if(x == 0)
            x = -1;
        
        cout << x << endl;
    }
}