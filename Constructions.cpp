#include <bits/stdc++.h>
using namespace std;

int dfs(int i, int j, int n, int m, int dp[100][100], int mat[100][100])
{
    if(i < 0 || j < 0 || i == n || j == m)
        return -1;
        
    if(dp[i][j] == -2)
        return -1;
        
    if(dp[i][j] != -1)
        return dp[i][j];
        
    if(mat[i][j] == 1)
        return dp[i][j] = 0;
        
    dp[i][j] = -2;
    
    int mx[4];
    
    mx[0] = dfs(i+1, j, n, m, dp, mat);
    mx[1] = dfs(i-1, j, n, m, dp, mat);
    mx[2] = dfs(i, j+1, n, m, dp, mat);
    mx[3] = dfs(i, j-1, n, m, dp, mat);
    
    int minV = n+m;
    
    for(int i = 0; i < 4; i++)
    {
        if(mx[i] != -1)
            minV = min(mx[i], minV);
    }
    
    return dp[i][j] = minV + 1;
}

int main()
{
    int n, m;
    cin >> n >> m;
    
    int mat[100][100];
    
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
            cin >> mat[i][j];
    }
    
    int dp[100][100];
    
    memset(dp, -1, sizeof(dp));
    
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            if(dp[i][j] == -1)
            {
                if(mat[i][j] == 1)
                    dp[i][j] = 0;
                
                else
                    dfs(i, j, n, m, dp, mat);
            }
        }
    }
    
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
            cout << dp[i][j] << " ";
        cout << endl;
    }
    
    return 0;
}
