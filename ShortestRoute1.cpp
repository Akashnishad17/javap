#include <bits/stdc++.h>
using namespace std;

struct Node{
    int x;
    long length;
    
    Node(int x, long length) 
        : x(x), length(length)
    {
    }
};

struct compareLength{
    bool operator()(Node const& a, Node const& b)
    {
        return a.length > b.length;
    }
}; 

int main()
{
    int n, m;
    
    cin >> n >> m;
    
    map < int, map < int, int > > my_map;
    int a,b,c;
    
    while(m--)
    {
        cin >> a >> b >> c;
        
        if(my_map.find(a) == my_map.end() || my_map[a].find(b) == my_map[a].end())
            my_map[a][b] = c;
        else
            my_map[a][b] = min(c, my_map[a][b]);
    }
    
    long res[n+1];
    bool visited[n+1];
    
    for(int i = 1; i <= n; i++)
        visited[i] = false;
    
    priority_queue <Node, vector<Node>, compareLength> pq;
    pq.push(Node(1, 0));
    
    map < int, int > :: iterator it;
    int count = 0;
    
    while(count < n)
    {
        Node node = pq.top();
        pq.pop();
        
        if(visited[node.x])
            continue;
        
        visited[node.x] = true;
        res[node.x] = node.length;
        
        for(it = my_map[node.x].begin(); it != my_map[node.x].end(); it++)
        {
            if(!visited[it->first])
                pq.push(Node(it->first, it->second + node.length));
        }
        
        count++;
    }
    
    for(int i = 1; i <= n; i++)
        cout << res[i] << " ";
}