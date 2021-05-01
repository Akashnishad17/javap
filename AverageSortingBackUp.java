import java.io.*;
import java.util.*;

class AverageSortingBackUp{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");
		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		if(n == 2)
			return arr[0] < arr[1] ? "Yes" : "No";

		double first = 0;
		double second = 0;
		double total = 0;

		for(int i = 0; i < n; i++)
			total += arr[i];

		for(int i = 0; i < n/2; i++)
			first += arr[i];

		for(int i = n/2; i < n; i++)
			second += arr[i];

		first /= (n/2);
		second /= (n - n/2);
		total /= n;

		return first < total && total < second ? "Yes" : "No";
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