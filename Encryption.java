import java.util.*;
import java.io.*;
class Encryption{
	//caeser chiper
	static String encrypt(String str, int key)
	{
		String res = "";
		int cur;
		for(int i = 0; i < str.length(); i++)
		{
			if(isUpper(str.charAt(i)))
			{
				cur = str.charAt(i) - 'A' - key;
				if(cur < 0)
					cur += 26;
				res += (char)(cur + 'A');
			}
			else
			{
				cur = str.charAt(i) - 'a' - key;
				if(cur < 0)
					cur += 26;
				res += (char)(cur + 'a');
			}
		}
		return res;
	}
	static String decrypt(String str, int key)
	{
		String res = "";
		int cur;
		for(int i = 0; i < str.length(); i++)
		{
			if(isUpper(str.charAt(i)))
			{
				cur = str.charAt(i) - 'A' + key;
				if(cur > 25)
					cur -= 26;
				res += (char)(cur + 'A');
			}
			else
			{
				cur = str.charAt(i) - 'a' + key;
				if(cur > 25)
					cur -= 26;
				res += (char)(cur + 'a');
			}
		}
		return res;
	}
	static boolean isUpper(char c)
	{
		return c >= 'A' && c <= 'Z';
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key(int): ");
		int k = sc.nextInt();
		System.out.print("Enter the plain text: ");
		String s = sc.next();
		String encryptedString = encrypt(s, k);
		String decryptedString = decrypt(encryptedString, k);
		System.out.println("Encrypted String: "+encryptedString);
		System.out.println("Decrypted String: "+decryptedString);
	}
}