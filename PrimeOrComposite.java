import java.io.*;
import java.util.*;

class PrimeOrComposite{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int max = 1000000;

		int[] prime = new int[max+1];

		Arrays.fill(prime, 1);

		prime[0] = 0;

		for(int i = 2; i <= 1000; i++)
		{
			if(prime[i] == 1)
			{
				for(int j = i*i; j <= max; j += i)
					prime[j] = 0;
			}
		}

		List<Integer> pr = new ArrayList<>();
		List<Integer> cm = new ArrayList<>();

		for(int i = 0; i < n; i++)
		{
			if(prime[arr[i]] == 1)
				pr.add(arr[i]);
			else
				cm.add(arr[i]);
		}

		Collections.sort(pr);
		Collections.sort(cm);

		int p = 0, c = cm.size() - 1;

		for(int i = 0; i < n; i++)
		{
			if(prime[arr[i]] == 1)
				arr[i] = pr.get(p++);
			else
				arr[i] = cm.get(c--);
		}


		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; i++)
			sb.append(arr[i]+" ");

		System.out.print(sb.toString());

	}
	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}