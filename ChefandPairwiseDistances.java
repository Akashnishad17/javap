import java.io.*;
import java.util.*;

class ChefandPairwiseDistances{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		if(n > 4)
			return "NO";

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		StringBuilder sb = new StringBuilder();
		sb.append("YES");

		if(n > 0)
			sb.append("\n"+(-arr[0])+" 0");

		if(n > 1)
			sb.append("\n"+arr[1]+" 0");

		if(n > 2)
			sb.append("\n0 "+(-arr[2]));

		if(n > 3)
			sb.append("\n0 "+arr[3]);

		return sb.toString();
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