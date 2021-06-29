import java.io.*; 
import java.util.*; 
  
class iteratorexample 
{ 
    public static void main(String[] args) 
    { 
        ArrayList<String> list = new ArrayList<String>(); 
        list.add("Akash"); 
        list.add("Akshat"); 
        list.add("Harshit"); 
        list.add("Arjun"); 
        list.add("Anirudh"); 
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
            System.out.println(iterator.next()); 
    } 
} 