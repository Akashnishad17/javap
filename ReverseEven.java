import java.io.*;
import java.util.*;

class ReverseEven{

	public static String reverse(String s) 
	{   
        String res = "";

        for(int i = s.length()-1; i >= 0; i--)
        	res += s.charAt(i);

        return res;
    }

	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		for(int i = 1; i < st.length; i += 2)
			st[i] = reverse(st[i]);

		String res = "";

		for(int i = 0; i < st.length; i++)
		{
			res += st[i];
			if(i < st.length - 1)
				res += " ";
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