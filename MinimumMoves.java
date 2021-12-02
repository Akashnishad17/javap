import java.io.*;
import java.util.*;

class MinimumMoves{

	public static int[] seg;

	public static void build(int[] arr, int index, int low, int high){
		
		if(low == high)
		{
			seg[index] = arr[low];
			return;
		}

		int mid = low + (high - low)/2;

		build(arr, 2*index + 1, low, mid);
		build(arr, 2*index + 2, mid+1, high);

		seg[index] = Math.min(seg[2*index+1], seg[2*index+2]);
	}

	public static int query(int index, int low, int high, int l, int r)
	{
		if(l <= low && high <= r)
			return seg[index];

		if(r < low || high < l)
			return Integer.MAX_VALUE;

		int mid = low + (high - low)/2;

		int left = query(2*index + 1, low, mid, l, r);
		int right = query(2*index + 2, mid +1, high, l, r);

		return Math.min(left, right);
	}

	public static long solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		List<Integer> child;

		for(int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(st[i]);

			child = map.getOrDefault(arr[i], new ArrayList<>());
			child.add(i);
			map.put(arr[i], child);
		}

		seg = new int[4*n];

		build(arr, 0, 0, n-1);

		HashMap<Integer, PriorityQueue<int[]>> minMap = new HashMap<>();

		int min = query(0, 0, n-1, 0, n-1);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[0]);
		pq.add(new int[]{0, n-1, 0});
		minMap.put(min, pq);

		long res = 0;
		int minIndex, lastMinIndex, newMin;

		for(Map.Entry<Integer,List<Integer>> e : map.entrySet())
		{
			min = e.getKey();
			child = e.getValue();

			int i = 0;
			lastMinIndex = -1;
			minIndex = -1;

			pq = minMap.get(min);

			int[] node = pq.poll();
			res += min - node[2];
			
			while(i < child.size())
			{
				if((int)child.get(i) > node[1])
				{
					node = pq.poll();
					res += min - node[2];
				}

				minIndex = child.get(i);
				if(lastMinIndex < node[0])
					lastMinIndex = node[0] - 1;

				if(minIndex - lastMinIndex > 1)
				{
					newMin = query(0, 0, n - 1, lastMinIndex + 1, minIndex - 1);
					PriorityQueue<int[]> newPQ = minMap.getOrDefault(newMin, new PriorityQueue<>((a,b) -> a[1] - b[0]));
					newPQ.add(new int[]{lastMinIndex + 1, minIndex - 1, min});
					minMap.put(newMin, newPQ);
				}

				lastMinIndex = minIndex;
				i++;

				if(i == child.size() || node[1] < child.get(i))
				{
					if(node[1] - lastMinIndex > 0)
					{
						newMin = query(0, 0, n - 1, lastMinIndex + 1, node[1]);
						PriorityQueue<int[]> newPQ = minMap.getOrDefault(newMin, new PriorityQueue<>((a,b) -> a[1] - b[0]));
						newPQ.add(new int[]{lastMinIndex + 1, node[1], min});
						minMap.put(newMin, newPQ);
					}
				}
			}
		}

		return res;
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