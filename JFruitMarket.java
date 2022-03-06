import java.io.*;
import java.util.*;

class JFruitMarket{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int count = Integer.parseInt(st[0]);

		int[] arr = new int[3];

		for(int i = 0; i < 3; i++)
			arr[i] = Integer.parseInt(st[i+1]);

		Arrays.sort(arr);

		return (count - 1) * arr[0] + arr[1];
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