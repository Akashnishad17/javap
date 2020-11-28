import java.io.*;
import java.util.*;

class ConcertTickets{

	public static int getIndex(List<Integer> arr, int r, int x)
	{
		if(r == -1)
			return -1;

		if((int)arr.get(0) > x)
			return -1;

		int mid, l = 0;

		while(r - l > 1)
		{
			mid = l + (r - l)/2;

			if((int)arr.get(mid) > x)
				r = mid - 1;
			
			else if((int)arr.get(mid) == x)
				r = mid;
			
			else
				l = mid;
		}

		return (int)arr.get(r) > x ? l : r;
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int m = sc.nextInt();

		List<Integer> arr = new LinkedList<>();
		for(int i = 0; i < n; i++)
			arr.add(sc.nextInt());

		Collections.sort(arr);

		int x;
		int index;
		while(m-- > 0)
		{
			x = sc.nextInt();
			index = getIndex(arr, n-1, x);

			if(index == -1)
				System.out.println(-1);

			else
			{
				System.out.println(arr.get(index));
				arr.remove(index);
				n--;
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}