import java.io.*;
import java.util.*;

class Password{
	public static void solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		boolean small = false, big = false, num = false, sym = false;

		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);

			if(c >= 'a' && c <= 'z')
				small = true;

			if(c >= 'A' && c <= 'Z')
			{
				if(i > 0 && i < s.length()-1)
					big = true;
			}

			if(c >= '0' && c <= '9')
			{
				if(i > 0 && i < s.length()-1)
					num = true;
			}

			if(c == '@' || c == '#' || c == '%' || c == '&' || c == '?')
			{
				if(i > 0 && i < s.length()-1)
					sym = true;
			}
		}

		if(small && big && num && sym && s.length() >= 10)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
			solve(br);
	}
}