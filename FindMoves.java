import java.io.*;
import java.util.*;

class FindMoves{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();
		int zeros = 0, ones = 0;

		int x = sc.nextInt();
		boolean flag = (x == 0);
		
		if(flag)
			zeros++;
		else
			ones++;

		for(int i = 1; i < n; i++)
		{
			x = sc.nextInt();
			if(x == 0 && !flag)
			{
				ones++;
				flag = !flag;
			}
			else if(x == 1 && flag)
			{
				zeros++;
				flag = !flag;
			}

		}


		System.out.println(Math.min(zeros, ones)+1);
	}

	public static void main(String[] args) throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}