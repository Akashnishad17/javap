import java.io.*;
import java.util.*;

class TwoButtons{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);

		boolean flag = true;
		while(flag)
		{
			int size = queue.size();
			while(size-- > 0)
			{
				n = queue.remove();
				if(n == m)
				{
					flag = false;
					break;
				}
				if(n == 1)
					queue.add(n*2);
				else if(n > m)
					queue.add(n-1);
				else
				{
					queue.add(n*2);
					queue.add(n-1);
				}
			}

			if(flag)
				count++;
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
		{
			solve(sc);
		}
	}
}