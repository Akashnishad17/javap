import java.io.*;
import java.util.*;

class ReverseStringParenthesis{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String res = solve(s);
		System.out.print(res);
	}

	public static String solve(String s)
	{
		if(s.length() == 0)
			return s;
		Stack<Character> st = new Stack<>();
		char c = s.charAt(0);
		st.add(c);
		for(int i = 1; i < s.length(); i++)
		{
			c = s.charAt(i);
			if(c == ')')
			{
				StringBuilder sub = new StringBuilder();
				while((char)st.peek() != '(')
				{
					c = st.pop();
					sub.append(c);
				}
				st.pop();
				for(int j = 0; j < sub.length(); j++)
					st.add(sub.charAt(j));
			}
			else
				st.add(c);
		}
		String res = "";
		while(!st.isEmpty())
			res = st.pop() + res;
		return res;
	}
}