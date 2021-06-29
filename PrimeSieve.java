import java.io.*;
import java.util.*;

class PrimeSieve{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n+1];
		if(n >= 2)
			nums[2] = 1;
		for(int i = 3; i <= n; i += 2)
			nums[i] = 1;
		for(int i = 3; i <= n; i += 2)
		{
			if(nums[i] == 1)
			{
				for(int j = i*i; j <= n; j += i)
					nums[j] = 0;
			}
		} 
		for(int i = 0; i <= n; i++)
		{
			if(nums[i] == 1)
				System.out.println(i);
		}
	}
}