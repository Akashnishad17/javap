import java.util.*;
import java.io.*;

class ValidString{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int res = solve(n, s);
		System.out.print(res);
	}

	public static int solve(int n, String s)
	{
		char[] chars = s.toCharArray();
		return backtrack(chars, 0, n);
	}
	public static int backtrack(char[] arr, int index, int n)
	{
		if(index == n)
			return checkValid(arr, n);
		if(arr[index] == '#')
		{
			int count = 0;
			arr[index] = 'A';
			count += backtrack(arr, index+1, n);
			arr[index] = 'a';
			count += backtrack(arr, index+1, n);
			arr[index] = 'B';
			count += backtrack(arr, index+1, n);
			arr[index] = 'b';
			count += backtrack(arr, index+1, n);
			arr[index] = 'C';
			count += backtrack(arr, index+1, n);
			arr[index] = 'c';
			count += backtrack(arr, index+1, n);
			arr[index] = '#';
			return count;
		}
		return backtrack(arr, index+1, n);
	}

	public static int checkValid(char[] arr, int n)
	{
		if(n == 0)
			return 1;
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < n; i++)
		{
			if(arr[i] == 'A' || arr[i] == 'B' || arr[i] == 'C')
				st.add(arr[i]);
			else
			{
				if(st.isEmpty())
					return 0;
				if(arr[i] == 'a' && (char)st.peek() != 'A')
					return 0;
				if(arr[i] == 'b' && (char)st.peek() != 'B')
					return 0;
				if(arr[i] == 'c' && (char)st.peek() != 'C')
					return 0;
				st.pop();
			}
		}
		return st.isEmpty() ? 1 : 0;
	}
}