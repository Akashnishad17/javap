import java.io.*; 
import java.util.*; 
  
class enumerationexample 
{ 
    public static void main(String[] args) 
    { 
        Vector<String> v = new Vector<String>(5);
        v.add("Hello");
        v.add("Hi");
        v.add("Hye");
        v.add("Bye");
        v.add("Goodbye");
        Enumeration iterator = v.elements();
        while (iterator.hasMoreElements()) 
            System.out.println(iterator.nextElement()); 
    } 
} 