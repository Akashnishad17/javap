import java.io.*;
import java.util.*;
class Authentication{
	static String username = "GlitchLeo";
	static String password = "#koenfbFAa@j!Af4nbBG@p5!rj!6Ca0jCG52qn6o33G";
	static boolean match(String user, String pass)
	{
		return user.equals(username) && pass.equals(password);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Username: ");
		String user = sc.next();
		System.out.print("Enter Password: ");
		String pass = sc.next();
		if(match(user,pass))
			System.out.print("Correct Username and Password!!!");
		else
			System.out.print("Incorrect Username or Password!!!");
	}
}