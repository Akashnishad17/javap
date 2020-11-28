import java.io.*;
import java.util.*;

class RowTrans{

	public static List<Integer> keys; 
	public static HashMap<Integer,Integer> map;

	public static String encrypt(String s, int rows, int key, int len)
	{
		String res = "";
		char[][] mat = new char[rows][key];
		int i = 0, j = 0, index = 0;
		
		System.out.println("The key matrix is: ");
		while(i < rows)
		{
			mat[i][j] = index < len ? s.charAt(index) : 'x';
			System.out.print(mat[i][j]+" ");
			index++;
			j++;
			if(j == key)
			{
				i++;
				j = 0;
				System.out.println();
			}
		}
		
		for(i = 1; i <= key; i++)
		{
			index = map.get(i);
			for(j = 0; j < rows; j++)
				res += mat[j][index];
		}
		return res;
	}

	public static String decrypt(String s, int rows, int key, int len)
	{
		char[][] mat = new char[rows][key];
		int i, j, index = 0, in; 
		
		for(i = 1; i <= key; i++)
		{
			in = map.get(i);
			for(j = 0; j < rows; j++)
				mat[j][in] = s.charAt(index++);
		}

		String res = "";
		i = 0; 
		j = 0;
		while(i < rows)
		{
			res += mat[i][j++];
			if(j == key)
			{
				i++;
				j = 0;
			}
		}
		return res.substring(0,len);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the cipher text: ");
		String s = sc.next();
		int len = s.length();
		int key = (int)Math.sqrt(len);;
		if(Math.floor(Math.sqrt(len)) != Math.ceil(Math.sqrt(len)))
		{
			if(len%(key+1)  > len%(key-1))	//if not a perfect square root then optimize to reduce the no. of fillings
				key++;
			else
				key--;
		}
		System.out.println("The length of key is "+key);

		keys = new ArrayList<>();
		map = new HashMap<>();
		for(int i = 1; i <= key; i++)
			keys.add(i);
		Collections.shuffle(keys);
		for(int i = 0; i < keys.size(); i++)
			map.put(keys.get(i), i);
		
		int rows = key*key == len ? key : (len/key + 1);
		System.out.println("The arrangement of key is: ");
		System.out.println(keys);
		
		String encrypted = encrypt(s, rows, key, len);
		String decrypted = decrypt(encrypted, rows, key, len);
		System.out.println("Encrypted text: "+encrypted);
		System.out.println("Decrypted text: "+decrypted);
	}
}