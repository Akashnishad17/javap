import java.util.*;
class stackexample
{
	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();
		s.push("Hello");
		s.push("Hye");
		s.push("Hi");
		System.out.println("Elements of stack are "+s);
		System.out.println("Poped element: "+s.pop());
		System.out.println("Poped element: "+s.pop());
		System.out.println("Elements of stack are "+s);
	}
}