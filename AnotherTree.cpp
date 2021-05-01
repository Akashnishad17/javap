#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define endl "\n"
#define f first
#define s second
#define ar array
#define pb push_back
#define forn(i, n) for(int i = 0; i < int(n); i++)
#define fore(i, l, r) for(int i = l; i <r; i++)
using vi = vector<int>;
template<typename T>
istream &operator>>(istream &in, vector<T> &vec) {
    for (auto &x : vec) {
        in >> x;
    }
    return in;
}
const int MXN = 2e5 + 2;
vi g[MXN];
int ans[MXN];
int leaf[MXN];
vector<pair<int,int>> queries[MXN];
unordered_map<int,vector<int>*>  level[MXN];
void dfsleaf(int u){
    if(g[u].size()==0){
        leaf[u]=1;
    }
    for(auto i:g[u]){
        dfsleaf(i);
        leaf[u]+=leaf[i];
    }
}

void merge(int x,int y){
    if(queries[x].size()<queries[y].size()){
        swap(queries[x],queries[y]);
    }
    for(auto i:queries[y]){
        queries[x].pb(i);
    }
}

void dfs(int u,int lvl){
    if(g[u].size()==0||leaf[u]==1){
        return;
    }
    int sz = g[u].size();
    if(g[u].size()==1){
        merge(g[u][0],u);
        swap(level[lvl+1],level[lvl]);
    }
    else {
        for (auto &i:level[lvl]) {
            if (i.f % sz != 0) {
                auto v=*i.s;
                for(auto x:v) {
                    ans[x] += i.f;
                }
            } else {
                level[lvl+1][i.f/sz]=i.s;
            }
        }
        for (auto &i:queries[u]) {
            if (i.f % sz != 0) {
                ans[i.s] += i.f;
            } else {
                if(level[lvl+1].count(i.f/sz)==0){
                    level[lvl+1][i.f/sz]=new vector<int>();
                }
                level[lvl+1][i.f/sz]->pb(i.s);
            }
        }
    }
    for(auto i:g[u]){
        dfs(i,lvl+1);
    }
    if(g[u].size()==1){
        swap(level[lvl+1],level[lvl]);
   }
    else{
        for (auto &i:queries[u]) {
            if (i.f % sz != 0) {
            } else {
                level[lvl+1][i.f/sz]->pop_back();
            }
        }
    }
    level[lvl+1].clear();
}

void terminator() {
    int n;
    cin>>n;
    forn(i,n-1){
        int u;
        cin>>u;
        g[u].pb(i+2);
    }
    dfsleaf(1);
    int q;
    
   cin>>q;
    for(int i=0;i<q;i++){
        ll v,k;
        cin>>v>>k;
        queries[v].pb({k,i});
    }
    dfs(1,1);
    forn(i,q){      
       cout<<ans[i]<<endl;
    }
}

int32_t main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t = 1, tc = 1;
    while (t--) {
        terminator();
        tc++;
    }
    return 0;
}