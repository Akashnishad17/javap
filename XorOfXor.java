import java.io.*;
import java.util.*;

// Xor all the elements of all pairs A[i] ^ A[j] where i < j from given A
class XorOfXor{
	public static void solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int res = 0;

		if(n % 2 == 0)
		{
			for(int i = 0; i < n; i++)
				res ^= arr[i];
		}

		System.out.println(res);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}