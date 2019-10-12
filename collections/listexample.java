import java.util.*;
class listexample
{
	public static void main(String[] args)
	{
		List<String> l = new ArrayList<String>();
		l.add("Akash");
		l.add("Akshat");
		l.add("Harshit");
		l.add(0,"Arjun");
		for(String name:l)
		{
			System.out.println(name);
		}
		System.out.println("Name at 1st index: "+l.get(1));
	}
}