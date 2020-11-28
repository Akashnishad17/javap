#include<bits/stdc++.h>
using namespace std;
 
#define N 1000010

int bit[N],n;

void update(int i,int val)
{
	while(i<=n)
	{
		bit[i]=max(bit[i],val);
		i=i+(i&(-i));
	}
}

int query(int i)
{
	int ret=0;
	while(i)
	{
		ret=max(ret,bit[i]);
		i=i-(i&(-i));
	}
	return ret;
}

vector<int> v[N];
int last[N],maxx[N],a[N];
int Out[N];
vector<pair<int,int> > Q[N];

void update_DAG(int cur,int val)
{
	if(val>maxx[cur])
	{
		for(auto x:v[cur])
			update_DAG(x,val+1);
		maxx[cur]=val;
		update(cur,val);
	}
}

int main()
{
	int q,i,j,s;
	
	scanf("%d",&n);
	scanf("%d",&q);
	scanf("%d",&s);

	for(i=0;i<=n;i++)
	{
		maxx[i]=last[i]=bit[i]=0;
		v[i].clear();
		Q[i].clear();
	}
	for(i=1;i<=n;i++)
	{
		scanf("%d",&a[i]);
		last[a[i]]=i;
		int prev=0;
		for(j=a[i]-1;j>=1;--j)
			if(last[j]>prev)
			{
				prev=last[j];
				v[last[j]].push_back(i);
			}
	}
	for(i=0;i<q;i++)
	{
		int x,y;

		scanf("%d",&x);
		scanf("%d",&y);

		if(x > y)
		{
			x = x + y;
			y = x - y;
			x = x - y;
		}

		Q[x].push_back(make_pair(y,i));
	}
	for(i=n;i>=1;--i)
	{
		update_DAG(i,1);
		
		for(j=0;j<Q[i].size();j++)
			Out[Q[i][j].second]=query(Q[i][j].first);
	}

	for(i=0;i<q;i++)
		printf("%d\n",Out[i]);
}