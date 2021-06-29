import java.io.*;
import java.util.*;

class EncodedString{
	public static String solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();

		String res = "";
		int num, i = 0;
		

		while(i < n)
		{
			num = 0;

			for(int j = 0; j < 4; j++)
			{
				num = (num << 1) + (s.charAt(i) - '0'); 
				i++;
			}

			res += (char)(num + 'a');
		}

		return res;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}