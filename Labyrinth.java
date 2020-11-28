import java.io.*;
import java.util.*;
 
class Labyrinth{
 
	public static class Node{
		int x, y;
		int dis;
		String path;
 
		public Node(int x, int y, int dis, String path)
		{
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.path = path;
		}
	}
 
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
 
		String[] grid = new String[n];
		boolean[][] visited = new boolean[n][m];
 
		int startX = -1, startY = -1, endX = -1, endY = -1;
		
		for(int i = 0; i < n; i++)
		{
			grid[i] = br.readLine();
 
			for(int j = 0; j < m; j++)
			{
				if(grid[i].charAt(j) == 'A')
				{
					startX = i;
					startY = j;
				}
 
				if(grid[i].charAt(j) == 'B')
				{
					endX = i;
					endY = j;
				}
			}
		}
 
		Queue<Node> queue = new LinkedList<>();
		Node node = new Node(startX, startY, 0, "");
 
		queue.add(node);
		visited[startX][startY] = true;
 
		while(!queue.isEmpty())
		{
			node = queue.remove();
			
			if(node.x == endX && node.y == endY)
			{
				System.out.println("YES");
				System.out.println(node.dis);
				System.out.print(node.path);
				return;
			}
 
			if(node.x+1 < n && !visited[node.x+1][node.y] && grid[node.x+1].charAt(node.y) != '#')
			{
				queue.add(new Node(node.x+1, node.y, node.dis+1, node.path + 'D'));
				visited[node.x+1][node.y] = true;
			}
 
			if(node.x-1 >= 0 && !visited[node.x-1][node.y] && grid[node.x-1].charAt(node.y) != '#')
			{
				queue.add(new Node(node.x-1, node.y, node.dis+1, node.path + 'U'));
				visited[node.x-1][node.y] = true;
			}
 
			if(node.y+1 < m && !visited[node.x][node.y+1] && grid[node.x].charAt(node.y+1) != '#')
			{
				queue.add(new Node(node.x, node.y+1, node.dis+1, node.path + 'R'));
				visited[node.x][node.y+1] = true;
			}
 
			if(node.y-1 >= 0 && !visited[node.x][node.y-1] && grid[node.x].charAt(node.y-1) != '#')
			{
				queue.add(new Node(node.x, node.y-1, node.dis+1, node.path + 'L'));
				visited[node.x][node.y-1] = true;
			}
		}
 
		System.out.print("NO");
	}
 
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
 
		solve(br);
	}
}