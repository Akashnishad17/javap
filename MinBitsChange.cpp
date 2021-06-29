#include <bits/stdc++.h>
using namespace std;

int main()
{
    int p, q;
    cin >> p >> q;
    
    bool f1 = true, f2 = true;
    
    if(p < 0)
    {
        p = -p;
        f1 = false;
    }
    
    if(q < 0)
    {
        q = -q;
        f2 = false;
    }
    
    int count = f1 == f2 ? 0 : 1;
    
    for(int i = 0; i < 16; i++)
    {
        if(p%2 != q%2)
            count++;
            
        p /= 2;
        q /= 2;
    }
    
    cout << count;
    
    return 0;
}
