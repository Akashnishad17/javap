import java.io.*;
import java.util.*;

class SubstringAllThree{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int res = solve(s);
		System.out.print(res);
	}

	public static int solve(String s)
	{
		Queue<Integer> a = new LinkedList<>();
		Queue<Integer> b = new LinkedList<>();
		Queue<Integer> c = new LinkedList<>();
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == 'a')
				a.add(i);
			if(s.charAt(i) == 'b')
				b.add(i);
			if(s.charAt(i) == 'c')
				c.add(i);
		}
		int left, right, prev = -1;
		int a_index, b_index, c_index;
		int res = 0;
		while(!a.isEmpty() && !b.isEmpty() && !c.isEmpty())
		{
			a_index = a.peek();
			b_index = b.peek();
			c_index = c.peek();
			left = Math.min(a_index,Math.min(b_index,c_index));
			right = Math.max(a_index,Math.max(b_index,c_index));
			res += (left-prev)*(s.length()-right);
			prev = left;
			if(a_index == left)
				a.remove();
			if(b_index == left)
				b.remove();
			if(c_index == left)
				c.remove();
		}
		return res;
	}
}