import java.util.*;
import java.io.*;
class GCD{
	static int gcd(int a, int b)
	{
		return a == 0 ? b : gcd(b%a, a);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter First Number: ");
		int a = sc.nextInt();
		System.out.print("Enter Second Number: ");
		int b = sc.nextInt();
		System.out.print("Gcd of the two numbers is "+gcd(a,b));
	}
}