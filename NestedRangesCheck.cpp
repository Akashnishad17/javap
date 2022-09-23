#include <bits/stdc++.h>
using namespace std;

struct Interval {
    int start, end, index;
};

bool cmp(Interval a, Interval b){
    return a.start == b.start ? a.end > b.end : a.start < b.start;
}

int main()
{
    int n;
    
    cin >> n;
    
    Interval arr[n];
    
    for(int i = 0; i < n; i++)
    {
        arr[i].index = i;
        cin >> arr[i].start >> arr[i].end;
    }
    
    sort(arr, arr + n, cmp);
    
    int dp[n][2];
    
    int mn = INT_MAX;
    
    for(int i = n - 1; i >= 0; i--)
	{
		dp[arr[i].index][0] = arr[i].end >= mn ? 1 : 0;
		mn = min(mn, arr[i].end);
	}

	int mx = INT_MIN;

	for(int i = 0; i < n; i++)
	{
	    dp[arr[i].index][1] = arr[i].end <= mx ? 1 : 0;
		mx = max(mx, arr[i].end);
	}

    for(int i = 0; i < n; i++)
        cout << dp[i][0] << " ";
        
    cout << endl;
    
    for(int i = 0; i < n; i++)
        cout << dp[i][1] << " ";
}




