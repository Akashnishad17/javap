import java.io.*;
import java.util.*;

class RandomArray{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		int x = Integer.parseInt(br.readLine());
		
		int[] arr = new int[x];

		int i;
		for(i = 0; i < x && n > 0; i++)
		{
			arr[i] = 1;
			n--;
		}

		if(n > 0)
			arr[x-1] += n;

		while(i < x)
		{
			arr[i] = 0;
			i++;
		}

		StringBuilder sb = new StringBuilder();

		for(int c : arr)
			sb.append(c+" ");

		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}