import java.util.*;
class vectorexample
{
	public static void main(String[] args)
	{
		Vector<String> v = new Vector<String>(5);
		v.add("Hello");
		v.add("Hi");
		v.add("Hye");
		v.add("Bye");
		v.add("Goodbye");
		System.out.println("Size of vector is "+v.size());
		System.out.println("Elements of vector are "+v);
		System.out.println("First element of vector is "+v.firstElement());
		System.out.println("Last element of vector is "+v.lastElement());
	}
}