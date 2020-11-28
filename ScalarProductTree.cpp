#include <bits/stdc++.h>
#define mod 4294967296L
using namespace std;

map <int , map <int, long> > lazy;
int first[300000], second[300000];

struct Node{
    long val, pre;
    int parent;
};

long query(int a, int b, Node nodes[])
{
    long res = 0;
    
    int count = 0;
    int small = a, big = b;

    while(a != b)
    {
        small = min(a, b);
        big = max(a, b);
        
        if(lazy.find(small) != lazy.end() && lazy[small].find(big) != lazy[small].end())
            break;
        
        res =  (res + (nodes[a].val * nodes[b].val) % mod) % mod;
        
        first[count] = small;
        second[count] = big;
        count++;
        
        a = nodes[a].parent;
        b = nodes[b].parent;
    }
    
    long val = a == b ? nodes[a].pre : lazy[small][big];
    res = (res + val) % mod;
    
    while(--count >= 0)
    {
        small = first[count];
        big = second[count];
        
        val = (val + (nodes[small].val * nodes[big].val) % mod) % mod;
        lazy[small][big] = val;
    }

    return res;
}

int main()
{
    int n, q;
    cin >> n >> q;
    
    Node nodes[n+1];
    long val;
    
    for(int i = 1; i <= n; i++)
    {
        cin >> val;
        nodes[i].val = val;
        nodes[i].pre = (val * val) % mod;
    }
    
    int x, y;
    
    map < int , list <int> > my_map;
    
    for(int i = 1; i < n; i++)
    {
        cin >> x >> y;
        
        my_map[x].push_back(y);
        my_map[y].push_back(x);
    }
    
    queue <int> qt;
    bool visited[n+1];
    
    for(int i = 2; i <= n; i++)
        visited[i] = false;
        
    qt.push(1);
    visited[1] = true;
    
    list <int> :: iterator it;
    
    while(qt.size() > 0)
    {
        x = qt.front();
        qt.pop();
        
        for(it = my_map[x].begin(); it != my_map[x].end(); ++it)
        {
            if(!visited[*it])
            {
                qt.push(*it);
                visited[*it] = true;
                
                nodes[*it].parent = x;
                nodes[*it].pre = (nodes[*it].pre + nodes[x].pre) % mod;
            }
        }
    }
    
    while(q--)
    {
        cin >> x >> y;
        
        cout << query(x, y, nodes) << endl;
    }
    
    return 0;
}