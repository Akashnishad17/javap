import java.io.*;
import java.util.*;

class TicTacToe{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] mat = new String[3];

		int empty = 0;
		int xCount = 0;
		int yCount = 0;

		for(int i = 0; i < 3; i++)
		{
			mat[i] = br.readLine();

			for(int j = 0; j < 3; j++)
			{
				if(mat[i].charAt(j) == '_')
					empty++;
				else if(mat[i].charAt(j) == 'X')
					xCount++;
				else
					yCount++;
			}
		}

		boolean x = checkWin(mat, 'X');
		boolean o = checkWin(mat, 'O');

		if(xCount < yCount || xCount - yCount > 1 || (x && o))
			return 3;

		if(x && xCount > yCount)
			return 1;

		if(o && xCount == yCount)
			return 1;

		if(!x && !o)
		{
			if(empty == 0)
				return 1;
			else
				return 2;
		}

		return 3;
	}

	public static boolean checkWin(String[] mat, char c)
	{
		for(int i = 0; i < 3; i++)
		{
			boolean flag = true;

			for(int j = 0; j < 3; j++)
			{
				if(mat[i].charAt(j) != c)
				{
					flag = false;
					break;
				}
			}

			if(flag)
				return true;
		}

		for(int j = 0; j < 3; j++)
		{
			boolean flag = true;

			for(int i = 0; i < 3; i++)
			{
				if(mat[i].charAt(j) != c)
				{
					flag = false;
					break;
				}
			}

			if(flag)
				return true;
		}

		boolean flag = true;

		for(int i = 0; i < 3; i++)
		{
			if(mat[i].charAt(i) != c)
			{
				flag = false;
				break;
			}
		}

		if(flag)
			return true;

		flag = true;

		for(int i = 0; i < 3; i++)
		{
			if(mat[i].charAt(2-i) != c)
			{
				flag = false;
				break;
			}
		}

		return flag;
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