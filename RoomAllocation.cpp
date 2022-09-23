#include <bits/stdc++.h>

using namespace std;

class Node{
    public:
    int val, index, flag;
    Node(int _val, int _index, int _flag){
        val = _val;
        index = _index;
        flag = _flag;
    }
};

class Compare{
    public:
    bool operator() (Node a, Node b){
        return a.val == b.val ? a.flag > b.flag : a.val > b.val;
    }
};

int main()
{
    int n;
    
    cin >> n;
    
    priority_queue<Node, vector<Node>, Compare> pq;
    
    for(int i = 0; i < n; i++)
    {
        int x,y;
        
        cin >> x >> y;
        
        pq.push(Node(x, i, 0));
        pq.push(Node(y, i, 1));
    }
    
    int count = 0;
    
    priority_queue<int> mex;
    
    int dp[n];
    
    while(!pq.empty()){
        Node node = pq.top();
        pq.pop();
        
        if(node.flag == 0)
        {
            if(mex.empty())
            {
                count++;
                dp[node.index] = count;
            }
            else
            {
                dp[node.index] = mex.top();
                mex.pop();
            }
        }
        else
            mex.push(dp[node.index]);
    }
    
    cout << count << endl;
    
    for(auto x : dp)
        cout << x << " ";
}



