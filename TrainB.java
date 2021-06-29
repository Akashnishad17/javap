import java.io.*;
import java.util.*;
import java.util.regex.*;

class TrainB{

	public static String helper(int hr, int min)
	{
		String h =  String.valueOf(hr);
		String m = String.valueOf(min);

		if(h.length() == 1)
			h = "0" + h;

		if(m.length() == 1)
			m = "0" + m;

		return " " + h + "." + m;
	}

	public static void solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();
		if(Pattern.matches("^([0-1][0-9]|2[0-3])[\\.][0-5][0-9]$", s))
		{
			int hr = Integer.parseInt(s.substring(0, 2));
			int min = Integer.parseInt(s.substring(3, 5));
			String res = s;

			min += 4;
			hr += min/60;
			min %= 60;
			res += helper(hr, min);

			min += 5;
			hr += min/60;
			min %= 60;
			res += helper(hr, min);
			
			min += 6;
			hr += min/60;
			min %= 60;
			res += helper(hr, min);
			
			min += 4;
			hr += min/60;
			min %= 60;
			res += helper(hr, min);
			
			min += 3;
			hr += min/60;
			min %= 60;
			res += helper(hr, min);

			System.out.print(res);
		}
		else
			System.out.print("INVALID INPUT");
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}