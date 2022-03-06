import java.io.*;
import java.util.*;

class MergedLIS{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[] arr1 = new int[n];
		int[] arr2 = new int[m];

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr1[i] = Integer.parseInt(st[i]);

		st = br.readLine().split(" ");

		for(int i = 0; i < m; i++)
			arr2[i] = Integer.parseInt(st[i]);

		int[] arr = new int[n+m];

		int i = 0, j = 0;

		while(i < n && j < m)
		{
			if(arr1[i] < arr2[j])
			{
				arr[i + j] = arr1[i];
				i++;
			}
			else
			{
				arr[i + j] = arr2[j];
				j++;
			}
		}

		while(i < n)
		{
			arr[i + j] = arr1[i];
			i++;
		}

		while(j < m)
		{
			arr[i + j] = arr2[j];
			j++;
		}

		List<Integer> list = new ArrayList<>();

		list.add(arr[0]);

		for(i = 1; i < n + m; i++)
		{
			if(arr[i] >= list.get(list.size() - 1))
				list.add(arr[i]);
			else
			{
				int index = findIndex(list, arr[i]);
				list.set(index, arr[i]);
			}
		}

		return list.size();
	}

	public static int findIndex(List<Integer> list, int val)
	{
		int l = 0, r = list.size() - 1;

		while(r - l > 1)
		{
			int mid = l + (r - l)/2;
			int middle = list.get(mid);

			if(middle <= val)
				l = mid + 1;
			else
				r = mid;
		}

		return list.get(l) <= val ? r : l;
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