#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    
    int arr[n];
    
    for(int i = 0; i < n; i++)
        cin >> arr[i];
        
    int dp[1000001];
    
    memset(dp, 0, sizeof(dp));
    
    for(int i = 0; i < n; i++)
    {
        int sq = (int)sqrt(arr[i]);
        
        for(int j = 1; j <= sq; j++)
        {
            if(arr[i] % j == 0)
            {
                dp[j]++;
                dp[arr[i]/j]++;
            }
        }
        
        if(sq * sq == arr[i])
            dp[sq]--;
    }
    
    int res = 1;
    
    for(int i = 2; i <= 1000000; i++)
    {
        if(dp[i] >= 2)
            res = i;
    }
    
    cout << res;
}