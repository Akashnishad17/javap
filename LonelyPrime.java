import java.io.*;
import java.util.*;

class LonelyPrime{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(",");

		HashMap<Integer,Integer> map = new HashMap<>();
		int num;

		for(String s : st)
		{
			num = Integer.parseInt(s);

			if(isPrime(num))
				map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int prime = -1;

		for(Map.Entry<Integer, Integer> e : map.entrySet())
		{
			if((int)e.getValue() == 1)
			{
				prime = e.getKey();
				break;
			}
		}

		System.out.print(prime);
	}

	public static boolean isPrime(int n)
	{
		if(n == 0 || n == 1)
			return false;

		if(n  == 2)
			return true;

		if(n % 2 == 0)
			return false;

		for(int i = 3; i <= (int)Math.sqrt(n); i += 2)
		{
			if(n % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}