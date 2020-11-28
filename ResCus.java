import java.io.*;
import java.util.*;

class ResCus{

	public static class Point{
		int val;
		int cor;
		public Point(int val, int cor)
		{
			this.val = val;
			this.cor = cor;
		}
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		Point[] points = new Point[2*n];

		int x;
		for(int i = 0; i < n; i++)
		{
			x = sc.nextInt();
			points[2*i] = new Point(x, 0);

			x = sc.nextInt();
			points[2*i+1] = new Point(x, 1);
		}

		Arrays.sort(points, new Comparator<Point>(){
			@Override
			public int compare(Point a, Point b)
			{
				if(a.val != b.val)
					return a.val - b.val;
				return a.cor - b.cor;
			}
		});

		int max = 0;
		int count = 0;

		for(Point p : points)
		{
			if(p.cor == 0)
				count++;
			else
				count--;

			max = Math.max(max, count);
		}

		System.out.print(max);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}