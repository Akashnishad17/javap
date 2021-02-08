import java.io.*;
import java.util.*;

class Moist{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];

		for(int i = 0; i < n; i++)
			arr[i] = br.readLine();

		int count = 0, j;
		String temp;

		for(int i = 1; i < n; i++)
		{
			j = i - 1;
			temp = arr[i];

			while(j >= 0 && arr[j].compareTo(temp) > 0)
			{
				arr[j+1] = arr[j];
				j--;
			}

			arr[j+1] = temp;

			if(j < i-1)
				count++;
		}

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}