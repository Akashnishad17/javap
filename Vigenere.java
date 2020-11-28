import java.io.*;
import java.util.*;

class Vigenere{

	public static String encrypt(String s, String key)
	{
		String res = "";
		for(int i = 0; i < s.length(); i++)
			res += (char)((s.charAt(i) -'a' + key.charAt(i % key.length()) - 'a') % 26 + 'a');
		return res;
	}

	public static String decrypt(String s, String key)
	{
		String res = "";
		for(int i = 0; i < s.length(); i++)
			res += (char)((s.charAt(i) - 'a' - (key.charAt(i % key.length()) - 'a') + 26) % 26 + 'a');
		return res;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key: ");
		String key = sc.next();
		System.out.print("Enter the plain text: ");
		String s = sc.next();
		String encrypted = encrypt(s, key);
		String decrypted = decrypt(encrypted, key);
		System.out.println("Encrypted String: "+encrypted);
		System.out.println("Decrypted String: "+decrypted);
	}
}