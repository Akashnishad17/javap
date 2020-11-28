import java.io.*;
import java.util.*;
class PasswordMatching{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = sc.next();
		System.out.print("Enter password: ");
		String password = sc.next();
		System.out.println("Username: "+username);
		System.out.print("Password: ");
		for(int i = 0; i < password.length(); i++)
			System.out.print("*");
	}
}