import java.io.*;
import java.util.*;

class SAes{

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

	public static void print(int[] arr)
	{
		for(int x : arr)
			System.out.print(x);

		System.out.println();
	}

	public static int[] convertStringToArray(String s, int n)
	{
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
			if(s.charAt(i) == '1')
				arr[i] = 1;
		}

		return arr;
	}

	public static void splitby2(int[] key, int[] d1, int[] d2)
	{
		for(int i = 0; i < 8; i++)
			d1[i] = key[i];

		for(int i = 8; i < 16; i++)
			d2[i-8] = key[i];
	}

	public static void fillHexa(int[] arr, int r, int x)
	{
		for(int i = r; i > r-4; i--)
			arr[i] = 0;

		while(x > 0)
		{
			arr[r--] = x%2;
			x /= 2;
		}
	}

	public static void generateKey(int[] w0, int[] w1, int[] w2, int[] w3, int[] key, int round)
	{
		int[] s0 = getRowColumn(w1, 4, 7);
		int[] s1 = getRowColumn(w1, 0, 3);

		int x = sbox[s0[0]][s0[1]];
		int y = sbox[s1[0]][s1[1]];

		int[] temp = new int[8];
		fillHexa(temp, 3, x);
		fillHexa(temp, 7, y);

		System.out.println("After applying RotNib & SubNib on w"+(round == 0 ? 1 : 3));
		print(temp);

		// for round 1 -> 10000000 and 2 -> 00110000
		for(int i = 0; i < 8; i++)
		{	
			w2[i] = w0[i] ^ temp[i];
			
			if(round == 0 && i == 0)
				w2[i] ^= 1;
			else if(round == 1 && (i == 2 || i == 3))
				w2[i] ^= 1;

			w3[i] = w2[i] ^ w1[i];

			key[i] = w2[i];
			key[i+8] = w3[i];
		}

	}

	public static int[] getRowColumn(int[] w, int l, int r)
	{
		return new int[]{w[l]*2 + w[l+1], w[r-1]*2 + w[r]};
	}

	public static int[] roundXor(int[] data, int[] key)
	{
		for(int i = 0; i < 16; i++)
			data[i] = data[i] ^ key[i];

		return data;
	}

	public static int[] encrypt(int[] data, int round)
	{
		int[] s;
		//sub nib
		for(int i = 0; i < 16; i += 4)
		{
			s = getRowColumn(data, i, i+3);
			fillHexa(data, i+3, sbox[s[0]][s[1]]);
		}

		System.out.println("After subNib");
		print(data);

		int temp;
		// rot nib
		for(int i = 4; i < 8; i++)
		{
			temp = data[i];
			data[i] = data[i+8];
			data[i+8] = temp;
		}

		System.out.println("Swap Nibble");
		print(data);

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

		// 1 * x = x but for 4 * x, we have look for the table
		int a00 = t[0] ^ mix[t[1]];
		int a10 = mix[t[0]] ^ t[1];
		int a01 = t[2] ^ mix[t[3]];
		int a11 = mix[t[2]] ^ t[3];

		fillHexa(data, 3, a00);
		fillHexa(data, 7, a10);
		fillHexa(data, 11, a01);
		fillHexa(data, 15, a11);

		System.out.println("After mixcolumn");
		print(data);
		
		return data;
	}

	public static void solve(Scanner sc)
	{
		String k = sc.next();
		String s = sc.next();

		key0 = convertStringToArray(k, 16);
		int[] data = convertStringToArray(s, 16);

		splitby2(key0, w0, w1);

		System.out.print("Key Generation\nKey0: ");
		print(key0);
		System.out.print("w0: ");
		print(w0);
		System.out.print("w1: ");
		print(w1);


		System.out.println("Finding w2 ans w3");

		// key generation
		generateKey(w0, w1, w2, w3, key1, 0);
		System.out.print("Key1: ");
		print(key1);
		System.out.print("w2: ");
		print(w2);
		System.out.print("w3: ");
		print(w3);

		System.out.println("Finding w4 ans w5");
		generateKey(w2, w3, w4, w5, key2, 1);
		System.out.print("Key2: ");
		print(key2);
		System.out.print("w4: ");
		print(w4);
		System.out.print("w5: ");
		print(w5);

		//round 0
		System.out.println("Round 0");
		data = roundXor(data, key0);
		System.out.println("xor with key0");
		print(data);

		// round 1
		System.out.println("Round 1");
		data = encrypt(data, 0);

		data = roundXor(data, key1);
		System.out.println("Xor with key1");
		print(data);

		// round 2
		System.out.println("Round 2");
		data = encrypt(data, 1);

		data = roundXor(data, key2);
		System.out.println("Xor with key2 -> final output");
		
		for(int i : data)	System.out.print(i);
	}

	public static void main(String[] args) throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));

		int t = 1;

		while(t-- > 0)
			solve(sc);
	}
}

/*
1010111100111011
0110011101101011
*/