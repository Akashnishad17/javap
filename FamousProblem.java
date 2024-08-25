import java.io.*;
import java.util.*;

public class FamousProblem
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		long sum = (1l * n * (n + 1)) / 2;
		long half = sum / 2;
		long cur = 0;
		
		int index = 0;
		
		while(index + 1 + cur <= half)
		    cur += ++index;
		
		if(cur < half)
		{
		    int v1 = index;
		    int v2 = -1;
		    
		    while(v1 >= 1)
		    {
		        v2 = (int)(half - cur + v1);
		        
		        if(v2 > v1 && v2 <= n)
		            break;
		            
		        v1--;
		    }
		    
		    for(int i = 1; i <= index; i++)
		    {
		        if(i == v1)
		            continue;
		            
		        System.out.print(i + " ");
		    }
		    
		    System.out.print(v2 + " " + v1 + " ");
		    
		    for(int i = index + 1; i <= n; i++)
		    {
		        if(i == v2)
		            continue;
		            
		        System.out.print(i + " ");
		    }
		    
		    return;
		}
		
		for(int i = 1; i <= n; i++)
		    System.out.print(i + " ");
	}
}
