#include <bits/stdc++.h>
using namespace std;

int main()
{
    string s, t;
    cin >> s >> t;
    
    int n = s.size();
    t += t;
    
    int mi = n/2;
    int ma = 0;
    int count;
    
    for(int i = 0; i <= n/2; i++)
    {
        count = 0;
        
        while(s[count] == t[count+i])
            count++;
            
        if(count > 0)
        {
            if(count > ma)
            {
                ma = count;
                mi = i;
            }
            
            else if(count == ma)
                mi = min(mi, i);
        }
        
        count = 0;
        
        while(s[count] == t[count+n-i])
            count++;
            
        if(count > 0)
        {
            if(count > ma)
            {
                ma = count;
                mi = i;
            }
            
            else if(count == ma)
                mi = min(mi, i);
        }
    }
    
    cout << (ma == 0 ? -1 : mi);
    
    return 0;
}