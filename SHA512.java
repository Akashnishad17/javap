import java.util.*;
import java.io.*;
import java.math.*;

public class SHA512{

	public static long[] H = new long[] 
	{
		0x6A09E667F3BCC908L,
		0xBB67AE8584CAA73BL,
		0x3C6EF372FE94F82BL,
		0xA54FF53A5F1D36F1L,
		0x510E527FADE682D1L,
		0x9B05688C2B3E6C1FL,
		0x1F83D9ABFB41BD6BL,
		0x5BE0CD19137E2179L
	};
	
	public static long[] K = new long[] 
	{
		0x428A2F98D728AE22L, 0x7137449123EF65CDL, 0xB5C0FBCFEC4D3B2FL, 0xE9B5DBA58189DBBCL, 0x3956C25BF348B538L,
		0x59F111F1B605D019L, 0x923F82A4AF194F9BL, 0xAB1C5ED5DA6D8118L, 0xD807AA98A3030242L, 0x12835B0145706FBEL,
		0x243185BE4EE4B28CL, 0x550C7DC3D5FFB4E2L, 0x72BE5D74F27B896FL, 0x80DEB1FE3B1696B1L, 0x9BDC06A725C71235L,
		0xC19BF174CF692694L, 0xE49B69C19EF14AD2L, 0xEFBE4786384F25E3L, 0x0FC19DC68B8CD5B5L, 0x240CA1CC77AC9C65L,
		0x2DE92C6F592B0275L, 0x4A7484AA6EA6E483L, 0x5CB0A9DCBD41FBD4L, 0x76F988DA831153B5L, 0x983E5152EE66DFABL,
		0xA831C66D2DB43210L, 0xB00327C898FB213FL, 0xBF597FC7BEEF0EE4L, 0xC6E00BF33DA88FC2L, 0xD5A79147930AA725L,
		0x06CA6351E003826FL, 0x142929670A0E6E70L, 0x27B70A8546D22FFCL, 0x2E1B21385C26C926L, 0x4D2C6DFC5AC42AEDL,
		0x53380D139D95B3DFL, 0x650A73548BAF63DEL, 0x766A0ABB3C77B2A8L, 0x81C2C92E47EDAEE6L, 0x92722C851482353BL,
		0xA2BFE8A14CF10364L, 0xA81A664BBC423001L, 0xC24B8B70D0F89791L, 0xC76C51A30654BE30L, 0xD192E819D6EF5218L,
		0xD69906245565A910L, 0xF40E35855771202AL, 0x106AA07032BBD1B8L, 0x19A4C116B8D2D0C8L, 0x1E376C085141AB53L,
		0x2748774CDF8EEB99L, 0x34B0BCB5E19B48A8L, 0x391C0CB3C5C95A63L, 0x4ED8AA4AE3418ACBL, 0x5B9CCA4F7763E373L,
		0x682E6FF3D6B2B8A3L, 0x748F82EE5DEFB2FCL, 0x78A5636F43172F60L, 0x84C87814A1F0AB72L, 0x8CC702081A6439ECL,
		0x90BEFFFA23631E28L, 0xA4506CEBDE82BDE9L, 0xBEF9A3F7B2C67915L, 0xC67178F2E372532BL, 0xCA273ECEEA26619CL,
		0xD186B8C721C0C207L, 0xEADA7DD6CDE0EB1EL, 0xF57D4F7FEE6ED178L, 0x06F067AA72176FBAL, 0x0A637DC5A2C898A6L,
		0x113F9804BEF90DAEL, 0x1B710B35131C471BL, 0x28DB77F523047D84L, 0x32CAAB7B40C72493L, 0x3C9EBE0A15C9BEBCL,
		0x431D67C49C100D4CL, 0x4CC5D4BECB3E42B6L, 0x597F299CFC657E2AL, 0x5FCB6FAB3AD6FAECL, 0x6C44198C4A475817L
	};

	public static void solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();
		System.out.print(sha512(s.getBytes()));
	}

	public static long Ch(long x, long y, long z) 
    {
		return (x & y) ^ ( ~x & z);
	}

	public static long Maj(long x, long y, long z) 
	{
		return (x & y) ^ (x & z) ^ (y & z);
	}

	public static long Sigma0(long x) 
	{
		return Rotr(x, 28) ^ Rotr(x, 34) ^ Rotr(x, 39);
	}

	public static long Sigma1(long x) 
	{
		return Rotr(x, 14) ^ Rotr(x, 18) ^ Rotr(x, 41);
	}

	public static long Delta0(long x) 
	{
		return Rotr(x, 1) ^ Rotr(x, 8) ^ (x >>> 7);
	}

	public static long Delta1(long x) 
	{
		return Rotr(x, 19) ^ Rotr(x, 61) ^ (x >>> 6);
	}

	public static long Rotr(long x, int n) 
	{
		return (x >>> n) | (x << (Long.SIZE - n));
	}

    public static String sha512(byte[] input) 
    {
    	int size = input.length + 17;
    	
    	while (size % 128 != 0)
    		size += 1;
   
    	byte[] out = new byte[size];
    	for (int i = 0; i < input.length; i++)
    		out[i] = input[i];

    	out[input.length] = (byte)0x80;
    	byte[] sizeBytes = BigInteger.valueOf(input.length * 8).toByteArray();

    	for (int i = sizeBytes.length; i > 0; i--)
    		out[size - i] = sizeBytes[sizeBytes.length - i];

    	long[][] M = new long[out.length/128][16];  

    	for(int i = 0; i < M.length; i++) 
    	{
    		for(int j = 0; j < 16; j++) 
    		{
    			long l = 0;

    			for(int x = 0; x < 8; x++)
    				l = (l << 8) + (out[x+ (i * 128 + j * 8)] & 0xff);
    			
    			M[i][j] = l;
    		}
    	}

    	long[][] W = new long[M.length][80];
    	
    	for(int i = 0; i < M.length; i++) 
    	{
    		for(int j = 0; j < 16; j++) 
    			W[i][j] = M[i][j];

    		for(int j = 16; j < 80; j++)
    			W[i][j] = W[i][j-16] + Delta0(W[i][j-15])+ W[i][j-7] + Delta1(W[i][j-2]);
   		}

   		long[] buffer = H.clone(); 

    	for (int i = 0; i < W.length; i++) 
    	{
   			long a = buffer[0];
   			long b = buffer[1];
   			long c = buffer[2];
   			long d = buffer[3];
    		long e = buffer[4];
    		long f = buffer[5];
    		long g = buffer[6];
   			long h = buffer[7];
    			
    		for (int j = 0; j < 80; j++) 
    		{
   				long temp1 = h + Sigma1(e) + Ch(e, f, g) + K[j] + W[i][j];
   				long temp2 = Sigma0(a) + Maj(a, b, c);
   				h = g;
    			g = f;
    			f = e;
    			e = d + temp1;
    			d = c;
   				c = b;
    			b = a;
    			a = temp1 + temp2;				
    		}

    		buffer[0] = a + buffer[0];
   			buffer[1] = b + buffer[1];
   			buffer[2] = c + buffer[2];
   			buffer[3] = d + buffer[3];
   			buffer[4] = e + buffer[4];
    		buffer[5] = f + buffer[5];
    		buffer[6] = g + buffer[6];
    		buffer[7] = h + buffer[7];
   		}
   		
   		String result = "";

   		for (int i = 0; i < 8; i++)
   			result += String.format("%016x", buffer[i]);

   		return result;
    }

	public static void main(String args[]) throws Exception
    {		
    	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
    }
}
