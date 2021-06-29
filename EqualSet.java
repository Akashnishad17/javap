import java.io.*;
import java.util.*;

class EqualSet{
	public static void solve(int n)
	{
		if(n % 4 == 1 || n % 4 == 2)
		{
			System.out.print("NO");
			return;
		}
		else
			System.out.println("YES");

		int set1 = (n / 4) * 2 + (n % 4 == 0 ? 0 : 2);
		int set2 = n - set1;

		System.out.println(set1);

		if(n % 4 == 0)
		{
			for(int i = 1; i <= n; i += 4)
				System.out.print(i+" "+(i+3)+" ");
		}
		else
		{
			System.out.print("1 2 ");
			for(int i = 4; i <= n; i += 4)
				System.out.print(i+" "+(i+3)+" ");
		}

		System.out.println();
		System.out.println(set2);

		if(n % 4 == 0)
		{
			for(int i = 2; i <= n; i += 4)
				System.out.print(i+" "+(i+1)+" ");
		}
		else
		{
			System.out.print("3 ");
			for(int i = 5; i <= n; i += 4)
				System.out.print(i+" "+(i+1)+" ");
		}

	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		int n = sc.nextInt();
		solve(n);
	}
}