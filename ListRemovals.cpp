#include <bits/stdc++.h>
using namespace std;

int seg[600000], arr[200001];

void build(int index, int low, int high)
{
    if(low == high)
    {
        seg[index] = 1;
        return;
    }
    
    int mid = (low + high)/2;
    
    build(2*index, low, mid);
    build(2*index+1, mid+1, high);
    
    seg[index] = seg[2*index] + seg[2*index+1];
}

int query(int index, int low, int high, int k)
{
    if(low == high)
    {
        seg[index] = 0;
        return arr[low];
    }
    
    int mid = (low + high)/2;
    int res;
    
    if(seg[2*index] >= k)
        res = query(2*index, low, mid, k);
    else
        res = query(2*index+1, mid+1, high, k-seg[2*index]);
    
    seg[index] = seg[2*index] + seg[2*index+1];
    return res;
}

int main()
{
    int n;
    cin >> n;
    
    for(int i = 1; i <= n; i++)
        cin >> arr[i];
        
    build(1, 1, n);
    
    int k;
    
    for(int i = 0; i < n; i++)
    {
        cin >> k;
        cout << query(1, 1, n, k) << " ";
    }
}




