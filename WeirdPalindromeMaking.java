import java.io.*;
import java.util.*;

class WeirdPalindromeMaking{
	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int count = 0;

		for(String s : st)
		{
			if(Integer.parseInt(s) % 2 == 1)
				count++;
		}

		return count/2;
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