import java.io.*;
import java.util.*;

class Codu{
	public static void solve(Scanner sc)
	{
		int m1 = sc.nextInt();
		int m2 = sc.nextInt();
		int r1 = sc.nextInt();

		int m1m2 = sc.nextInt();
		int m1r1 = sc.nextInt();
		int m2r1 = sc.nextInt();

		int m1m2r1 = sc.nextInt();

		int res1 = r1 - m1r1 - m2r1 + m1m2r1;
		int res2 = m1m2 - m1m2r1;

		System.out.print(res1+" "+res2);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("input6.txt"));
		//System.setOut(new PrintStream(new File("output.txt")));
		
		solve(sc);
	}
}