import java.io.*;
import java.util.*;

class HillCipher{

	public static String encrypt(String s, int[][] key)
	{
		String res = "";
		int sum;
		for(int i = 0; i < s.length(); i += 3)
		{
			for(int j = 0; j < 3; j++)
			{
				sum = 0;
				for(int k = 0; k < 3; k++)
					sum += key[k][j]*(s.charAt(i+k) - 'a');
				res += (char)((sum % 26) + 'a');
			}
		}
		return res;
	}

	public static int modInverse(int a)
	{
		for(int i = 1; i < 26; i++)
		{
			if((a*i)%26 == 1)
				return i;
		}
		return 1;
	}

	public static int[][] inverseMatrix(int[][] key)
	{
		int[][] A = new int[3][3];
		A[0][0] = 	key[1][1]*key[2][2] - key[1][2]*key[2][1];
		A[0][1] = -(key[1][0]*key[2][2] - key[1][2]*key[2][0]);
		A[0][2] = 	key[1][0]*key[2][1] - key[1][1]*key[2][0];
		A[1][0] = -(key[0][1]*key[2][2] - key[0][2]*key[2][1]);
		A[1][1] = 	key[0][0]*key[2][2] - key[0][2]*key[2][0];
		A[1][2] = -(key[0][0]*key[2][1] - key[0][1]*key[2][0]);
		A[2][0] = 	key[0][1]*key[1][2] - key[0][2]*key[1][1];
		A[2][1] = -(key[0][0]*key[1][2] - key[0][2]*key[1][0]);
		A[2][2] = 	key[0][0]*key[1][1] - key[0][1]*key[1][0];
		int d = 0;
		for(int i = 0; i < 3; i++)
			d += A[0][i]*key[0][i];
		if(d < 0)
			d = 26 - (-d)%26;
		d %= 26;
		d = modInverse(d);
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				A[i][j] *= d;
				if(A[i][j] < 0)
					A[i][j] = 26 - (-A[i][j])%26;
				A[i][j] %= 26;
			}
		}
		int t;
		for(int i = 0; i < 3; i++)
		{
			for(int j = i+1; j < 3; j++)
			{
				t = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = t;
			}
		}
		return A;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key: ");
		String k = sc.next();
		System.out.print("Enter the plain text: ");
		String s = sc.next();
		while(s.length()%3 != 0)
			s += 'x';
		int[][] key = new int[3][3];
		int c = 0;
		System.out.println("The key matrix is: ");
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				key[i][j] = k.charAt((c++)%k.length()) - 'a';
				System.out.print(key[i][j]+" ");
			}
			System.out.println();
		}
		int[][] keyInverse = inverseMatrix(key);
		System.out.println("The key inverse matrix is: ");
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
				System.out.print(keyInverse[i][j]+" ");
			System.out.println();
		}
		String encrypted = encrypt(s, key);
		String decrypted = encrypt(encrypted, keyInverse);
		System.out.println("Encrypted text: "+encrypted);
		System.out.println("Decrypted text: "+decrypted);
	}
}