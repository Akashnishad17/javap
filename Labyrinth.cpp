#include<bits/stdc++.h>
using namespace std;

 
class Node
{
	public:
		int x, y;
		int dis;
		string path;

	Node(int x, int y, int dis, string path)
	{
		this->x = x;
		this->y = y;
		this->dis = dis;
		this->path = path;
	}
};

void solve()
{

	int n; cin>>n;
	int m; cin>>m;

	char grid[n][m];
	bool visited[n][m];
		
	int startX = -1, startY = -1, endX = -1, endY = -1;
	
	for(int i = 0; i < n; i++)
	{
	    for(int j = 0; j < m; j++)
	        cin >> grid[i][j];
	}
		
	for(int i = 0; i < n; i++)
	{

		for(int j = 0; j < m; j++)
		{
			if(grid[i][j] == 'A')
			{
				startX = i;
				startY = j;
			}

			if(grid[i][j] == 'B')
			{
				endX = i;
				endY = j;
			}
		}
	}

	queue<Node> que;
	Node node = *(new Node(startX, startY, 0, ""));

	que.push(node);
	visited[startX][startY] = true;

	while(!que.empty())
	{
		node = que.front();
		que.pop();
		
		if(node.x == endX && node.y == endY)
		{
			cout<<"YES"<<endl;
			cout<<node.dis<<endl;
			cout<<node.path;
			return;
		}

		if(node.x+1 < n && !visited[node.x+1][node.y] && grid[node.x+1][node.y] != '#')
		{
			que.push(*(new Node(node.x+1, node.y, node.dis+1, node.path + "D")));
			visited[node.x+1][node.y] = true;
		}

		if(node.x-1 >= 0 && !visited[node.x-1][node.y] && grid[node.x-1][node.y] != '#')
		{
			que.push(*(new Node(node.x-1, node.y, node.dis+1, node.path + "U")));
			visited[node.x-1][node.y] = true;
		}

		if(node.y+1 < m && !visited[node.x][node.y+1] && grid[node.x][node.y+1] != '#')
		{
			que.push(*(new Node(node.x, node.y+1, node.dis+1, node.path + "R")));
			visited[node.x][node.y+1] = true;
		}

		if(node.y-1 >= 0 && !visited[node.x][node.y-1] && grid[node.x][node.y-1] != '#')
		{
			que.push(*(new Node(node.x, node.y-1, node.dis+1, node.path + "L")));
			visited[node.x][node.y-1] = true;
		}
	}

	cout<<"NO";
}

int main()
{
	solve();
	return 0;
}
