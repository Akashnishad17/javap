import java.io.*;
import java.util.*;

class AnyCombination{
	public static int solve(String[] st, int index, int val)
	{
		if(index == st.length)
			return val;

		if(st[index].equals("Left"))
			return solve(st, index+1, 2*val);

		else if(st[index].equals("Right"))
			return solve(st, index+1, 2*val+1);

		else
			return solve(st, index+1, val) + solve(st, index+1, 2*val) + solve(st, index+1, 2*val+1);
	}

	public static void main(String[] args)
	{
		String[] st = new Scanner(System.in).nextLine().split(",");
		System.out.print(solve(st, 0, 1));
	}
}