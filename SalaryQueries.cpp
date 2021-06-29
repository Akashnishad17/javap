#include <bits/stdc++.h>
using namespace std;

int seg[600000][2];

void build(int arr[], int index, int low, int high)
{
    if(low == high)
    {
        seg[index][0] = arr[low];
        seg[index][1] = arr[high];
        return;
    }
    
    int mid = (low + high)/2;
    
    build(arr, 2*index, low, mid);
    build(arr, 2*index+1, mid+1, high);
    
    seg[index][0]  = min(seg[2*index][0], seg[2*index+1][0]);
    seg[index][1]  = max(seg[2*index][1], seg[2*index+1][1]);
}

int query(int index, int low, int high, int a, int b)
{
    if(b < seg[index][0] || a > seg[index][1])
        return 0;
        
    if(a <= seg[index][0] && seg[index][1] <= b)
        return high - low + 1;
    else if(low == high)
        return 0;
        
    int mid = (low + high)/2;
    
    int left = query(2*index, low, mid, a, b);
    int right = query(2*index+1, mid+1, high, a, b);
    
    return left + right;
}

void update(int index, int low, int high, int k, int x)
{
    if(low == high)
    {
        seg[index][0] = x;
        seg[index][1] = x;
        return;
    }
    
    int mid = (low + high)/2;
    
    if(k <= mid)
        update(2*index, low, mid, k, x);
    else
        update(2*index+1, mid+1, high, k-mid, x);
        
    seg[index][0]  = min(seg[2*index][0], seg[2*index+1][0]);
    seg[index][1]  = max(seg[2*index][1], seg[2*index+1][1]);
}

int main()
{
    int n, q;
    cin >> n >> q;
    
    int arr[n+1];
    
    for(int i = 1; i <= n; i++)
        cin >> arr[i];
        
    build(arr, 1, 1, n);
    
    int x,y;
    char c;
    
    while(q--)
    {
        cin >> c >> x >> y;
        if(c == '!')
            update(1, 1, n, x, y);
        else
            cout << query(1, 1, n, x, y) << endl;
    }
}




