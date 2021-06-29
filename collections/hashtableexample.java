import java.util.*;
class hashtableexample
{
	public static void main(String[] args)
	{
		Hashtable<Integer,String> h = new Hashtable<Integer,String>();
		h.put(5,"Akash");
		h.put(7,"Akshat");
		h.put(9,"Anirudh");
		h.put(12,"Arjun");
		h.put(23,"Harshit");
		for(Map.Entry m:h.entrySet())
		{
			System.out.println(m.getKey()+":"+m.getValue());
		}
	}
}