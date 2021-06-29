import java.io.*;
import java.util.*;
import java.util.regex.*;

class IDWithDomain{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" |,");

		String id = null;
		String domain = null;

		for(String s : st)
		{
			if(Pattern.matches("^[A-Z]{5}[0-9]{4}[A-Z]$", s))
				id = s;

			if(Pattern.matches("^(www)[\\.][a-zA-Z0-9]+[\\.](com)$", s))
				domain = s.substring(s.indexOf(".") + 1);
		}

		System.out.print(id+" "+domain);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		solve(br);
	}
}