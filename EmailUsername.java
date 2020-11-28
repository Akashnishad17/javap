import java.io.*;
import java.util.*;

class EmailUsername{

	public static void solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		int i = 0;
		while(s.charAt(i) != '@')
			i++;

		i++;
		String res = "";

		while(s.charAt(i) != '.')
		{
			res += s.charAt(i);
			i++;
		}

		System.out.print(res);
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}