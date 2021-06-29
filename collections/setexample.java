import java.util.*;
class setexample
{
	public static void main(String[] args)
	{
		Set<String> s = new HashSet<String>();
		s.add("Akash");
		s.add("Akshat");
		s.add("Arjun");
		s.add("Arjun");
		s.add("Akash");
		System.out.println(s);
	}
}