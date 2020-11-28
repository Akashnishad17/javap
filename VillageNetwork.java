import java.io.*;
import java.util.*;

class VillageNetwork{

	public static class Point{
		long x, y;

		public Point(long x, long y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public static void solve(Scanner sc)
	{
		long x = sc.nextLong();
		long y = sc.nextLong();
		long tarX = sc.nextLong();
		long tarY = sc.nextLong();

		Queue<Point> queue = new LinkedList<>();

		Point pt = new Point(x, y);
		queue.add(pt);

		long count = 0;
		boolean found = false;

		while(true)
		{
			int size = queue.size();

			while(size-- > 0)
			{
				pt = queue.remove();
				if(pt.x == tarX && pt.y == tarY)
				{
					found = true;
					break;
				}

				x = pt.x;
				y = pt.y;

				queue.add(new Point(x + 2*y, y));
				queue.add(new Point(x - 2*y, y));

				if(y + 2*x > 0)
					queue.add(new Point(x, y + 2*x));
				else if(y + 2*x < 0)
					queue.add(new Point(-x, -(y + 2*x)));

				if(y - 2*x > 0)
					queue.add(new Point(x, y - 2*x));
				else if(y - 2*x < 0) 
					queue.add(new Point(-x,-(y - 2*x)));
			}

			if(found)
				break;

			count++;
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = sc.nextInt();
		while(t-- > 0)
			solve(sc);
	}
}