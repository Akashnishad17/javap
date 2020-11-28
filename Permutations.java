import java.io.*;
import java.util.*;

class Permutations{
	public static void solve(Scanner sc)
	{
		int n = sc.nextInt();

		if(n == 2 || n == 3)
		{
			System.out.print("NO SOLUTION");
			return;
		}

		for(int i = 2; i <= n; i += 2)
			System.out.print(i+" ");

		for(int i = 1; i <= n; i += 2)
			System.out.print(i+" ");
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}