import java.io.*;
import java.util.*;

public class TestCase
{
    static int genrate()
    {
        double num = Math.random()*1000;
        return (int)num;
    } 
    
	public static void main(String[] args) throws Exception{
        
        System.setOut(new PrintStream(new File("output.txt")));
        
        int n = 1000;
        System.out.println(n+" "+genrate()+" "+genrate());
        
        for(int i = 0; i < n; i++)
            System.out.print(genrate()+" ");
	}
}