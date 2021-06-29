import java.io.*;
import java.util.*;

class LuckyDivision{

	public static boolean isLucky(int n)
	{
		while(n > 0)
		{
			if(n%10 == 7 || n%10 == 4);
			else
				return false;
			n /= 10;
		}
		return true;
	}

	public static boolean evenDivide(int n)
	{
		int[] arr = new int[]{4,7,44,47,74,77,444,447,474,477,744,747,774,777};
		for(int i = 0; i < arr.length; i++)
		{
			if(n % arr[i] == 0)
				return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String res = evenDivide(n) || isLucky(n) ? "YES" : "NO";
		System.out.print(res);
	}
}