import java.io.*;
import java.util.*;

class KickStart{
	public static int solve(BufferedReader br) throws Exception
	{
		char[] s = br.readLine().toCharArray();

		int count = 0;
		int kickCount = 0;
		
		for(int i = 0; i < s.length-3; i++)
		{
			if(i+3 < s.length && s[i] == 'K' && s[i+1] == 'I' && s[i+2] == 'C' && s[i+3] == 'K')
				kickCount++;

			if(i+4 < s.length && s[i] == 'S' && s[i+1] == 'T' && s[i+2] == 'A' && s[i+3] == 'R' && s[i+4] == 'T')
				count += kickCount;
		}

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
			System.out.println("Case #"+i+": "+solve(br));
	}
}