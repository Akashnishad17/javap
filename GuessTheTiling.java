import java.io.*;
import java.util.*;

class GuessTheTiling{

	public static int[][] grid = new int[][]{{1,1},{1,0}};
	public static int[][] change = new int[][]{{1,1},{1,0}};

	public boolean query(int n)
	{
		int count = 0;

		for(int i = 0; i < n-1; i++)
		{
			for(int j = 0; j < n-1; j++)
			{
				if(change[i][j] == 0 && change[i][j+1] == 1 && change[i+1][j] == 1 && change[i+1][j+1])
					count++;
			}
		}

		return count;
	}
	
	public static void solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

	
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