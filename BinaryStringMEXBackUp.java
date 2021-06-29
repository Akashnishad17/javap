import java.io.*;
import java.util.*;

class BinaryStringMEXBackUp{
	
	public static String solve(BufferedReader br) throws Exception
	{
		String s = br.readLine();

		int n = s.length();

		int[] arr0 = new int[n+1];
		int[] arr1 = new int[n+1];

		int[] dp0 = new int[n+2];
		int[] dp1 = new int[n+2];

		int pos0 = n, pos1 = n;

		for(int i = n - 1; i >= 0; i--)
		{
			if(s.charAt(i) == '0')
				pos0 = i;

			if(s.charAt(i) == '1')
				pos1 = i;

			arr0[i] = pos0;
			arr1[i] = pos1;		

			if(s.charAt(i) == '0' && pos1 < n)
				dp0[i] = Math.max(dp0[i+1], dp0[pos1 + 1] + 1);
			else if(s.charAt(i) == '1' && pos0 < n)
				dp0[i] = Math.max(dp0[i+1], dp0[pos0 + 1] + 1);
			else
				dp0[i] = dp0[i+1];
				
			if(pos1 < n)
				dp1[i] = Math.max(dp1[i+1], dp0[pos1 + 1] + 1);
			else
				dp1[i] = dp1[i+1];
		}

		if(pos0 == n)
			return "0";

		StringBuilder sb = new StringBuilder("1");

		pos1++;

		for(int i = 1; i <= dp1[0]; i++)
		{
			if(pos1 >= n)
				sb.append("0");
			else if(arr0[pos1] >= n)
			{
				sb.append("0");
				pos1 = arr0[pos1] + 1;
			}
			else if(dp0[arr0[pos1] + 1] < dp1[0] - i)
			{
				sb.append("0");
				pos1 = arr0[pos1] + 1;
			}
			else
			{
				sb.append("1");
				pos1 = arr1[pos1] + 1;
			}
		}		

		return sb.toString();
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