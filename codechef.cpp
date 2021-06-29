#include <iostream>
using namespace std;

long long getSumby2Index(long long r, long long sum)
{
    long long l = 1, mid, range;
    while(l < r)
    {
        mid = l + (r-l)/2;
        range = (mid*(mid+1))/2;
        if(range == sum)
            return mid;
        else if(range > sum)
            r = mid - 1;
        else
            l = mid + 1;
    }
    range = l*(l+1)/2;
    if(range > sum)
        l--;
    return l;
}

void solve()
{
    long long n;
    cin>>n;
    if(n % 4 == 1 || n % 4 == 2)
    {
        cout<<"0"<<endl;
        return;
    }
    long long sum = (n*(n+1))/2;
    sum /= 2;
    long long right = getSumby2Index(n, sum);
    long long i = right-1;
    long long range = (i*(i+1))/2;
    long long j, diff, l1, l2, k, min, count = 0;
    
    while(i <= right)
    {
        if(range == sum)
        {
            j = n - i;
            count += (i*(i-1))/2 + (j*(j-1))/2;
            break;
        }
        else
        {
            diff = sum - range;
            l2 = i + 1;
            l1 = l2 - diff;
            k = l1;
            if(k <= 0)
            {
                l1 += (1 - k);
                l2 += (1 - k);
            }
            if(l2 <= n)
            {
                min = n - l2 + 1;
                if(i - l1 + 1 < min)
                    min = i - l1 + 1;
                count += min;
            }
        }
        range += ++i;
    }
    cout<<count<<endl;
}

int main()
{
    int t;
    cin>>t;
    while(t-- > 0)
    {
        solve();
    }
}
