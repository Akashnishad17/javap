#include <algorithm>

struct Interval {
    long start, end;
};

bool cmp(Interval i1, Interval i2)
{
    return i1.start == i2.start ? i1.end < i2.end : i1.start < i2.start;
}

int upperBound(Interval arr[], int l, int r, long x)
    {
        int mid;

        while(r - l > 1)
        {
            mid = l + (r - l)/2;

            if(arr[mid].start > x)
                r = mid - 1;
            else
                l = mid;
        }

        return arr[r].start > x ? l : r;
    }

int solution(vector<int> &A) {
    
    int n = A.size();

    Interval arr[n];

    for(int i = 0; i < n; i++)
    {
        arr[i].start = i - (long)A[i];
        arr[i].end = i + (long)A[i];
    }

    sort(arr, arr + n, cmp);
    int count = 0;

    for(int i = 0; i < n; i++)
    {
        count += upperBound(arr, i, n-1, arr[i].end) - i;
        if(count > 10000000)
            return -1;
    }

    return count;
}
