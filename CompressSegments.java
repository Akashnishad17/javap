import java.io.*;
import java.util.*;


class CompressSegments{

	public static int xorValue(int x, int y)
	{	
		int xor = x^y;

		if(xor == 0)
			return 0;
		
		int count = 1;
		
		while(xor > 0)
		{
			count *= 2;
			xor /= 2;
		}

		return count/2;
	}

	public static class MyComp implements Comparator<Integer>
	{
		@Override
			public int compare(Integer a, Integer b)
			{
				int x = (int)a;
				int y = (int)b;

				int b1 = 0, b2 = 0;
				while(x > 0 && x%2 == 0)
				{
					b1++;
					x /= 2;
				}

				while(y > 0 && y%2 == 0)
				{
					b2++;
					y /= 2;
				}

				if(b1 != b2)
					return b1 - b2;

				return x - y;
			}
	}

	public static int getMinElement(int[] arr, int l, int r)
	{
		if(l == r)
			return arr[l];

		PriorityQueue<Integer> list = new PriorityQueue<>(new MyComp());

		boolean flag = false;
		for(int i = l; i <= r; i++)
		{
			if(arr[i] > 0)
				list.add(arr[i]);
			else
			    flag = true;
		}

		int xor;
		int x, y;

		while(list.size() > 1)
		{
			x = list.remove();
			y = list.remove();

			xor = xorValue(x, y);
			if(xor > 0)
				list.add(xor);
		}

        if(list.size() == 0)
			return 0;

		xor = list.remove();

		return flag ? xorValue(0, xor) : xor;
	}

	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int[] arr = new int[n];

		int sum = 0;
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int x;
		for(int i = 0; i < n; i++)
		{
			for(int j = i; j < n; j++)
			{
				x = getMinElement(arr, i, j);
				sum += x;
				sum %= 998244353;
			}
		}

		System.out.print(sum);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}


/*public static class DoubleEndPriorityQueue{
		
		private HashMap<Integer,Integer> set;

		public DoubleEndPriorityQueue()
		{
			set = new HashMap<>();
		}

		public void remove(int x)
		{
			set.put(x, set.get(x) - 1);
			if(set.get(x) == 0)
				set.remove(x);
		}

		public int removeMin()
		{
			int min = Collections.min(set.keySet());
			remove(min);
			return min;
		}

		public int removeMax()
		{
			int max = Collections.max(set.keySet());
			remove(max);
			return max;
		}

		public int getMin()
		{
			return Collections.min(set.keySet());
		}

		public int get(int x)
		{
			return set.get(x);
		}

		public int size()
		{
			return (int)set.size();
		}

		public void add(int x)
		{
			set.put(x, set.getOrDefault(x, 0) + 1);
		}
	}*/

	/*List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i < 32; i++)
			list.add(new ArrayList<>());

		int bit;
		for(int i = l; i <= r; i++)
		{
			if(arr[i] == 0)
				continue;

			bit = xorValue(arr[i]);
			list.get(bit).add(arr[i]);
		}

		int xor;

		for(int i = 31; i >= 0; i--)
		{
			if(list.get(i).size() == 0)
				continue;

			if(list.get(i).size() % 2 != 0)
				return (int)Math.pow(2, i);

			xor = 0;
			for(int x : list.get(i))
				xor ^= x;

			if(xor > 0)
			{
				bit = xorValue(xor);
				list.get(bit).add((int)Math.pow(2,bit));
			}
		}*/