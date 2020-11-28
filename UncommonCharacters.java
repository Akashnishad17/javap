import java.io.*;
import java.util.*;

class UncommonCharacters{
	public static void solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();
		String p = br.readLine();
		
		int[] dp1 = new int[26];
		int[] dp2 = new int[26];

		for(int i = 0; i < s.length(); i++)
			dp1[s.charAt(i) - 'a']++;

		for(int i = 0; i < p.length(); i++)
			dp2[p.charAt(i) - 'a']++;

		for(int i = 0; i < 26; i++)
		{
			if((dp1[i] > 0 && dp2[i] == 0) || (dp1[i] == 0 && dp2[i] > 0))
				System.out.print((char)(i+'a')+" ");
		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}