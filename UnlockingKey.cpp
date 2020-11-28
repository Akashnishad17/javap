#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    
    bool neg = false;
    
    if(n < 0)
    {
        neg = true;
        n = -n;
    }
    
    int dp[10];
    for(int i = 0; i < 10; i++)
        dp[i] = 0;
        
    while(n > 0)
    {
        dp[n%10]++;
        n /= 10;
    }
    
    int num = 0;
    
    if(neg)
    {
       for(int i = 9; i >= 0; i--)
       {
           while(dp[i] > 0)
           {
               num = num*10 + i;
               dp[i]--;
           }
       }
       
        num = -num; 
    }
    else
    {
        int index = -1;
        
        for(int i = 1; i < 10; i++)
        {
            if(dp[i] > 0)
            {
                index = i;
                break;
            }
        }
        
        if(index != -1)
        {
            num = index;
            dp[index]--;
        }
        
        for(int i = 0; i < 10; i++)
       {
           while(dp[i] > 0)
           {
               num = num*10 + i;
               dp[i]--;
           }
       }
    }
    
    cout << num;
    
    return 0;
}
