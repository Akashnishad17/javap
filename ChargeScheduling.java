import java.io.*;
import java.util.*;

class ChargeScheduling{

	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[][] arr = new int[n][3];

		for(int i = 0; i < n; i++)
		{
			arr[i][0] = Integer.parseInt(st[i]);
			arr[i][2] = i + 1;
		}

		st = br.readLine().split(" ");

		for(int i = 0; i < n; i++)
			arr[i][1] = Integer.parseInt(st[i]);

		Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int max = arr[0][1];

		List<int[]> res = new ArrayList<>();

		for(int i = 0; i < n; i++)
		{
			int l = res.size() == 0 ? 0 : res.get(i-1)[2];
			int r = l + arr[i][0];

			if(r > max)
				break;

			res.add(new int[]{arr[i][2], l, r});
		}

		sb.append(res.size()+"\n");

		for(int[] a : res)
			sb.append(a[0]+" "+a[1]+" "+a[2]+"\n");
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
			solve(br);

		System.out.print(sb.toString());
	}
}