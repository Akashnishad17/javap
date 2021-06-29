import java.io.*;
import java.util.*;

class StockSpan{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int[] res = new int[n];
		Stack<Integer> st = new Stack<>();
		st.add(0);
		res[0] = 1;
		for(int i = 1; i < n; i++)
		{
			res[i] = 1;
			while(!st.isEmpty() && arr[st.peek()] <= arr[i])
				st.pop();
			res[i] = i + (st.isEmpty() ? 1 : -st.peek());
			st.add(i);
		}
		for(int i = 0; i < n; i++)
			System.out.print(res[i]+" ");
	}
}