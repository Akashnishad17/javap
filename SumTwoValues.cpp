#include <bits/stdc++.h>
using namespace std;

struct Value{
	int val, index;
};

bool cmp(Value a, Value b)
{
    if(a.val != b.val)
	    return a.val < b.val;
	 return a.index < b.index;
}

int getIndex(Value arr[], int x, int r)
{
    int l = 0, mid;
    
    while(r - l > 1)
    {
        mid = l + (r - l)/2;
        if(arr[mid].val > x)
            r = mid - 1;
            
        else if(arr[mid].val < x)
            l = mid + 1;
            
        else
            l = mid;
    }
    
    if(arr[l].val != x && arr[r].val != x)
        return -1;
        
    if(arr[l].val == x)
        return arr[l].index;
        
    return arr[r].index;
}

int main()
{
	int n, x;

	cin >> n >> x;

	Value arr[n];

	for(int i = 0; i < n; i++)
	{
		cin >> arr[i].val;
		arr[i].index = i + 1;
	}

	sort(arr, arr+n, cmp);
	int index;

	for(int i = 0; i < n; i++)
	{
	    index = getIndex(arr, x - arr[i].val, n-1);
	    
	    if(index != -1 && index != arr[i].index)
	    {
	        cout << index << " " << arr[i].index;
	        return 0;
	    }
	}

	cout << "IMPOSSIBLE";
}