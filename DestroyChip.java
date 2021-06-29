import java.io.*;
import java.util.*;

class DestroyChip{
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int t = Integer.parseInt(st[0]);
		int d = Integer.parseInt(st[1]);

		while(t-- > 0)
		{
			long l = -10e18, r = 10e18, yl = l, yr = r;
			long mid;
			String res;

			while(l <= r)
			{
				mid = (l + r)/2;

				System.out.println(1+" "+mid+" "+0);					

				res = br.readLine();

				if(res.charAt(0) == 'X')
				{
					System.out.println(2+" "+mid+" "+yl+" "+mid+" "+yr);
					res = br.readLine();
					break;
				}

				else if(res.charAt(0) == 'N')
					l = mid + 1;
				else
					r = mid - 1;
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}