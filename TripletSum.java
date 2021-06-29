import java.io.*;
import java.util.*;
class TripletSum{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			List<int[]> res = new ArrayList<>();
			int max = Integer.MIN_VALUE;
			int sum;
			for(int i = 0; i < n-2; i++)
			{
				for(int j = i+1; j < n-1; j++)
				{
					for(int k = j+1; k < n; k++)
					{
						if(arr[i] > arr[j] || arr[j] > arr[k])
							continue;
						sum = arr[i] + arr[j] + arr[k];
						if(sum > max)
						{
							sum = max;
							res.clear();
							res.add(new int[]{i+1,j+1,k+1});
						}
						else if(sum == max)
							res.add(new int[]{i+1,j+1,k+1});
					}
				}
			}
			Collections.sort(res, new Comparator<int[]>(){
				@Override
				public int compare(int[] a, int[] b)
				{
					if(a[0] != b[0])
						return a[0] - b[0];
					if(a[1] != b[1])
						return a[1] - b[1];
					return a[2] - b[2];
				}
			});
			if(res.size() == 0)
				System.out.println(-1);
			else
			{
				int[] out = res.get(0);
				System.out.println(out[0]+" "+out[1]+" "+out[2]);
			}
		}

	}
}