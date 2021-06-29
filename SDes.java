import java.io.*;
import java.util.*;

class SDes{

	static int[] p10 = new int[]{3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
	static int[] p8 = new int[]{6, 3, 7, 4, 8, 5, 10, 9};
	
	static int[] ip = new int[]{2, 6, 3, 1, 4, 8, 5, 7};
	static int[] ep = new int[]{4, 1, 2, 3, 2, 3, 4, 1};
	static int[] ip_1 = new int[]{4, 1, 3, 5, 7, 2, 8, 6};
	static int[] p4 = new int[]{2, 4, 3, 1};
	
	static int[][] s0 = new int[][]{{1, 0, 3, 2},
									{3, 2, 1, 0},
									{0, 2, 1, 3},
									{3, 1, 3, 2}};
	static int[][] s1 = new int[][]{{0, 1, 2, 3},
									{2, 0, 1, 3},
									{3, 0, 1, 0},
									{2, 1, 0, 3}};
	
	static int[] key1 = new int[8];
	static int[] key2 = new int[8];

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

	public static void print(int[] arr)
	{
		for(int x : arr)
			System.out.print(x);

		System.out.println();
	}

	public static void solve(Scanner sc)
	{
		String k = sc.next();
		String s = sc.next();

		keyGeneration(convertStringToArray(k, 10));
		
		int[] res = convertStringToArray(s, 8);

		//apply ip
		int[] ip_out = new int[8];
		for(int i = 0; i < 8; i++)
			ip_out[i] = res[ip[i] - 1];

		System.out.println("Encryption:\nAfter Ip");
		print(ip_out);

		//round 1 
		System.out.println("Round 1:");
		res = encrypt(ip_out, key1);
		
		//apply SW
		int temp;
		for(int i = 0; i < 4; i++)
		{
			temp = res[i];
			res[i] = res[i+4];
			res[i+4] = temp;
		}

		System.out.println("After SW");
		print(res);
		
		//round 2
		System.out.println("Round 2:");
		res = encrypt(res, key2);

		// apply IP-1
		System.out.println("After ip-1 -> final output");
		for(int i = 0; i < 8; i++)
			System.out.print(res[ip_1[i]-1]);

		System.out.println();
	}

	public static int[] encrypt(int[] s, int[] k)
	{
		System.out.println("Input for the round:");
		print(s);

		//apply ep with second part and xor with key
		int[] ep_out = new int[8];
		for(int i = 0; i < 8; i++)
			ep_out[i] = s[ep[i]-1 + 4];

		System.out.println("After ep on second part");
		print(ep_out);

		for(int i = 0; i < 8; i++)
			ep_out[i] ^= k[i];

		System.out.println("After xor with key");
		print(ep_out);

		// apply S0 and S1
		int[] s_0 = getRowColumn(ep_out, 0, 3);
		int[] s_1 = getRowColumn(ep_out, 4, 7);

		int x = s0[s_0[0]][s_0[1]];
		int y = s1[s_1[0]][s_1[1]];

		int[] s_out = new int[4];
		s_out[1] = x%2;
		x /= 2;
		s_out[0] = x%2;
		s_out[3] = y%2;
		y /= 2;
		s_out[2] = y%2;

		System.out.println("After applying S-box");
		print(s_out);

		// apply p4 and xor with s first part
		int[] p4_out = new int[4];
		for(int i = 0; i < 4; i++)
			p4_out[i] = s_out[p4[i] - 1];

		System.out.println("After p4");
		print(p4_out);

		for(int i = 0; i < 4; i++)
			p4_out[i] ^= s[i];

		System.out.println("After xor with first part");
		print(p4_out);

		int[] res = new int[8];
		for(int i = 0; i < 4; i++)
			res[i] = p4_out[i];
		for(int i = 4; i < 8; i++)
			res[i] = s[i];

		System.out.println("After adding 2nd part");
		print(res);

		return res;
	}

	public static int[] getRowColumn(int[] arr, int l, int r)
	{
		return new int[]{arr[l]*2+arr[r], arr[l+1]*2+arr[r-1]};
	}

	public static void keyGeneration(int[] key)
	{
		//apply p10
		int[] p10_out = new int[10];

		for(int i = 0; i < 10; i++)
			p10_out[i] = key[p10[i]-1];

		System.out.println("key Generation:\nAfter p10");
		print(p10_out);

		//LS-1 
		rotateLeft(p10_out, 0, 4);
		rotateLeft(p10_out, 5, 9);

		System.out.println("After LS-1");
		print(p10_out);

		//apply p8 -> key1
		for(int i = 0; i < 8; i++)
			key1[i] = p10_out[p8[i]-1];

		System.out.println("After p8 -> key1");
		print(key1);

		//LS-2
		//shifting two bits 
		rotateLeft(p10_out, 0, 4);
		rotateLeft(p10_out, 5, 9);
		rotateLeft(p10_out, 0, 4);
		rotateLeft(p10_out, 5, 9);

		System.out.println("After LS-2");
		print(p10_out);

		//apply p8 -> key2
		for(int i = 0; i < 8; i++)
			key2[i] = p10_out[p8[i]-1];

		System.out.println("After p8 -> key2");
		print(key2);
	}

	public static void rotateLeft(int[] arr, int left, int right)
	{
		// only shift bit at a time
		int temp = arr[left];
		for(int i = left; i < right; i++)
			arr[i] = arr[i+1];
		arr[right] = temp;
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		int t = 1;
		while(t-- > 0)
			solve(sc);
	}
}

/*
2
0010010111
10100101
1010100010
01100010
*/