import java.io.*;
import java.util.*;

class SumOfSquareRoot{
	public static void solve(BufferedReader br) throws Exception
	{

		try{

			String[] st = br.readLine().split(" ");
			int num, sqrt, sum = 0;

			for(int i = 0; i < st.length; i++)
			{
				num = Integer.parseInt(st[i]);
				sqrt = (int)Math.sqrt(num);

				if(sqrt * sqrt == num)
					sum += sqrt;
			}

			System.out.print(sum);
		}
		catch(Exception e)
		{
			System.out.print(-1);
		}

	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}