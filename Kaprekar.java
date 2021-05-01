import java.io.*;
import java.util.*;

class Kaprekar{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		if(n == 6174)
			return 0;

		int i = 1;

		while(i <= 100)
		{
			int[] arr = new int[4];

			int j = 0;

			while(n > 0)
			{
				arr[j++] = n % 10;
				n /= 10;
			}

			Arrays.sort(arr);
			int num1 = 0;
			int num2 = 0;

			for(j = 0; j < 4; j++)
			{
				num1 = num1 * 10 + arr[j];
				num2 = num2 * 10 + arr[3-j];
			}

			n = num2 - num1;

			if(n == 6174)
				return i;

			i++;
		}

		return -1;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}