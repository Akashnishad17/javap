import java.io.*;
import java.util.*;

class WatchingCPL{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int k = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		Arrays.sort(arr);
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		List<Integer> index;

		for(int i = 0; i < n; i++)
		{
			index = map.getOrDefault(arr[i], new ArrayList<>());
			index.add(i);
			map.put(arr[i], index);
		}

		int[] dp = new int[n];

		int t1 = 0, t2 = 0, count = 0, diff, low, high;

		while(t1 < k && map.size() > 0)
		{
			diff = k - t1;

			if(map.containsKey(diff))
			{
				index = map.get(diff);
				dp[index.get(0)] = 1;
				
				t1 += diff;
				index.remove(0);

				if(index.size() == 0)
					map.remove(diff);
				count++;
			}
			else if(map.lowerKey(diff) != null)
			{
				low = map.lowerKey(diff);
				index = map.get(low);
				dp[index.get(0)] = 1;

				t1 += low;
				index.remove(0);

				if(index.size() == 0)
					map.remove(low);

				count++;
			}

			else if(map.higherKey(diff) != null)
			{
				high = map.higherKey(diff);
				index = map.get(high);
				dp[index.get(0)] = 1;

				t1 += high;
				index.remove(0);

				if(index.size() == 0)
					map.remove(high);

				count++;
			}	
		}

		if(t1 < k)
			return -1;

		for(int i = 0; i < n; i++)
		{
			if(dp[i] == 1 && t1 - arr[i] >= k)
			{
				dp[i] = 0;
				t1 -= arr[i];
				count--;

				index = map.getOrDefault(arr[i], new ArrayList<>());
				index.add(i);
				map.put(arr[i], index);
			} 
			else
				break;
		}

		while(t2 < k && map.size() > 0)
		{
			diff = k - t2;

			if(map.containsKey(diff))
			{
				index = map.get(diff);
				dp[index.get(0)] = 2;
				
				t2 += diff;
				index.remove(0);

				if(index.size() == 0)
					map.remove(diff);
				count++;
			}
			else if(map.higherKey(diff) != null)
			{
				high = map.higherKey(diff);
				index = map.get(high);
				dp[index.get(0)] = 2;

				t2 += high;
				index.remove(0);

				if(index.size() == 0)
					map.remove(high);

				count++;
			}
			else if(map.lowerKey(diff) != null)
			{
				low = map.lowerKey(diff);
				index = map.get(low);
				dp[index.get(0)] = 2;

				t2 += low;
				index.remove(0);

				if(index.size() == 0)
					map.remove(low);

				count++;
			}
		}

		int l, r, mid;

		if(t2 < k)
		{
			high = t1 - k;
			low = k - t2;

			if(high < low)
				return -1;

			index = new ArrayList<>();

			for(int i = 0; i < n; i++)
			{
				if(dp[i] == 2)
					index.add(i);
			}

			for(int i = 1; i < n; i++)
			{
				if(dp[i] == 1)
				{
					l = 0; 
					r = index.size() - 1;

					while(l <= r)
					{
						mid = l + (r - l)/2;
						diff = arr[i] - arr[index.get(mid)];

						if(low <= diff && diff <= high)
							return count;

						if(diff < low)
							r = mid - 1;
						else
							l = mid + 1;
					}
				}
			}

			return -1;
		}

		l = 0; 
		r = n - 1;

		while(l < r)
		{
			while(r >= 0 && dp[r] != 0)
				r--;

			if(r == -1)
				break;

			while(l < n && dp[l] != 1)
				l++;

			if(l < r)
			{
				t1 += arr[r];
				dp[r] = 1;
				count++;

				while(l < r)
				{
					if(dp[l] == 1 && t1 - arr[l] >= k)
					{
						t1 -= arr[l];
						dp[l] = 0;
						count--;
					}
					l++;
				}
			}
		}

		for(int x : dp)
			System.out.print(x+" ");
		System.out.println();

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}