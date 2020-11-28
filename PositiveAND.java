import java.io.*;
import java.util.*;

class PositiveAND{

	public static boolean isPowerof2(int n)
	{
		if(n == 1)
			return true;
		
		if(n%2 != 0)
			return false;
		
		return isPowerof2(n/2);
	}

	public static int[] solve(Scanner sc)
	{
		int n = sc.nextInt();
		
		if(n == 1)
			return new int[]{1};

		if(n == 3)
			return new int[]{1,3,2};

		if(n == 5)
			return new int[]{4,5,1,3,2};
		
		if(isPowerof2(n))
			return new int[]{-1};

		int[] arr = new int[n];
		arr[0] = 4;
		arr[1] = 5;
		arr[2] = 1;
		arr[3] = 3;
		arr[4] = 2;

		int next = 6;
		int pow = 8;
		int temp;
		for(int i = 5; i < n; i++)
		{
			arr[i] = next;
			
			if(next-1 == pow)
			{
				temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
				pow *= 2;
			}
			
			next++;
		}

		return arr;
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int[] res = solve(sc);
			for(int x : res)
				System.out.print(x+" ");
			System.out.println();
		}
	}
}



/*
import java.io.*;
import java.util.*;

class Codechef{

	public static boolean isPowerof2(int n)
	{
		return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
	}

	public static void solve(int n)
	{
		if(n == 1)
		{
		    System.out.print("1");
			return;
		}

		if(n == 3)
		{
		    System.out.print("1 3 2");
			return;
		}

		if(n == 5)
		{
		    System.out.print("4 5 1 3 2");
			return;
		}
		
		if(isPowerof2(n))
		{
		    System.out.print("-1");
		    return;
		}

		
		System.out.print("4 5 1 3 2 ");

		int next = 6;
		int pow = 8;
		
		for(int i = 5; i < n; i++)
		{
			if(next == pow)
			{
				System.out.print((next+1)+" "+next+" ");
				pow *= 2;
				i++;
				next++;
			}
			else
			    System.out.print(next+" ");
			next++;
		}
		
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
			solve(n);
			System.out.println();
		}
	}
}
*/