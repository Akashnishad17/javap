import java.io.*;
import java.util.*;

class saes2{

	static int[] w0 = new int[8];
	static int[] w1 = new int[8];
	static int[] w2 = new int[8];
	static int[] w3 = new int[8];
	static int[] w4 = new int[8];
	static int[] w5 = new int[8];

	static int[] mix = new int[]{0, 4, 8, 12, 3, 7, 11, 15, 6, 2, 14, 10, 5, 1, 13, 9};
	static int[][] sbox = new int[][]{{9, 4, 10, 11},
									{13, 1, 8, 5},
									{6, 2, 0, 3},
									{12, 14, 15, 7}};

	static int[] key0 = new int[16];
	static int[] key1 = new int[16];
	static int[] key2 = new int[16];


	public static int[] stringToArray(String s, int n)
	{
		int[] a = new int[n];
		for(int i = 0; i < n; i++)
		{
			if(s.charAt(i) == '1')
				a[i] = 1;
		}

		return a;
	}

	public static void splitintwo(int[] key, int[] d1, int[] d2)
	{
		for(int i = 0; i < 8; i++)
			d1[i] = key[i];

		for(int i = 8; i < 16; i++)
			d2[i-8] = key[i];
	}

	public static void hexa(int[] a, int r, int x)
	{
		for(int i = r; i > r-4; i--)
			a[i] = 0;

		while(x > 0)
		{
			a[r--] = x%2;
			x /= 2;
		}
	}

	public static void getKey(int[] w0, int[] w1, int[] w2, int[] w3, int[] key, int round)
	{
		int[] s0 = getCell(w1, 4, 7);
		int[] s1 = getCell(w1, 0, 3);

		int x = sbox[s0[0]][s0[1]];
		int y = sbox[s1[0]][s1[1]];

		int[] t = new int[8];
		hexa(t, 3, x);
		
		hexa(t, 7, y);

		
		for(int i = 0; i < 8; i++)
		{	
			w2[i] = w0[i] ^ t[i];
			
			if(round == 0 && i == 0)
				w2[i] ^= 1;
			else if(round == 1 && (i == 2 || i == 3))
				w2[i] ^= 1;

			w3[i] = w2[i] ^ w1[i];

			key[i] = w2[i];
			key[i+8] = w3[i];
		}
	}

	public static int[] getCell(int[] w, int l, int r)
	{
		return new int[]{w[l]*2 + w[l+1], w[r-1]*2 + w[r]};
	}

	public static int[] roundXor(int[] data, int[] key)
	{
		for(int i = 0; i < 16; i++)
			data[i] = data[i] ^ key[i];

		return data;
	}

	public static int[] encryption(int[] data, int round)
	{
		int[] s;
		//sub nib
		for(int i = 0; i < 16; i += 4)
		{
			s = getCell(data, i, i+3);
			hexa(data, i+3, sbox[s[0]][s[1]]);
		}

		int temp;
		// rot nib
		for(int i = 4; i < 8; i++)
		{
			temp = data[i];
			data[i] = data[i+8];
			data[i+8] = temp;
		}

		if(round == 0)
			data = mixColumn(data);

		return data;
	}

	public static int[] mixColumn(int[] data)
	{
		int[] t = new int[4];
		// hexa to decimal one nibble to decimal
		for(int i = 0; i < 4; i++)
			t[i] = data[4*i]*8 + data[4*i+1]*4 + data[4*i+2]*2 + data[4*i+3];

		
		int a00 = t[0] ^ mix[t[2]];
		int a01 = mix[t[0]] ^ t[2];
		int a10 = t[1] ^ mix[t[3]];
		int a11 = mix[t[1]] ^ t[3];

		hexa(data, 3, a00);
		hexa(data, 7, a10);
		hexa(data, 11, a01);
		hexa(data, 15, a11);
		
		return data;
	}

	// public static void saes(Scanner sc)
	
	public static void main(String[] args) throws Exception
	{
		
		Scanner input = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));

		int i = 1;

		while(i-- > 0)
		{
		    String k = input.next();
			String s = input.next();
// 			String k = "1011011100111011";
// 			String s = "0111111101101011";

			key0 = stringToArray(k, 16);
			int[] data = stringToArray(s, 16);

			splitintwo(key0, w0, w1);

			
			getKey(w0, w1, w2, w3, key1, 0);
			getKey(w2, w3, w4, w5, key2, 1);

			//round 0
			data = roundXor(data, key0);

			// round 1
			data = encryption(data, 0);
			data = roundXor(data, key1);

			// round 2
			data = encryption(data, 1);
			data = roundXor(data, key2);

			for(int x : data)	System.out.print(i);
		}
	}
}