#include <bits/stdc++.h>
using namespace std;

int seg[600000];

void build(int arr[], int index, int low, int high)
{
    if(low == high)
    {
        seg[index] = arr[low];
        return;
    }
    
    int mid = (low + high)/2;
    
    build(arr, 2*index, low, mid);
    build(arr, 2*index+1, mid+1, high);
    
    seg[index] = max(seg[2*index], seg[2*index+1]);
}

int query(int index, int low, int high, int x)
{
    if(seg[index] < x)
        return 0;
        
    if(low == high)
    {
        seg[index] -= x;
        return low;
    }
    
    int mid = (low + high)/2;
    
    int left = query(2*index, low, mid, x);
    int right = 0;
    
    if(left == 0)
    {
        right = query(2*index+1, mid+1, high, x);
        seg[index] = max(seg[2*index], seg[2*index+1]);
        return right;
    }
        
    seg[index] = max(seg[2*index], seg[2*index+1]);
    return left;
}

int main()
{
    int n, m;
    cin >> n >> m;
    
    int arr[n+1];
    
    for(int i = 1; i <= n; i++)
        cin >> arr[i];
        
    build(arr, 1, 1, n);
    
    int x;
    
    while(m--)
    {
        cin >> x;
        cout << query(1, 1, n, x) << " ";
    }
}