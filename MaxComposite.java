import java.io.*;
import java.util.*;

class MaxComposite{

	public static void main(String[] args)
	{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input6.txt"));
		System.setOut(new PrintStream(new File("output1.txt")));
		int l = sc.nextInt();
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

		int last = -1; 
		
		int i = l;
		int diff;

		while(i <= n)
		{
			if(nums[i] == 1)
			{
				if(last == -1)
				{
					diff = (i - 1) - l + 1;
					if(diff > 5)
						System.out.println(l+" "+(i-1)+diff);
				}

				last = i;
				i++;
				while(i <= n && nums[i] == 0)
					i++;

				diff = (i - 1) - (last+1) + 1;
				if(diff > 5)
				{
					System.out.println((last+1)+" "+(i-1)+" "+diff);
				}

				last = i;
			}
			else
				i++;
		}

		diff = n - (last+1) + 1;
		if(diff > 5)
		{
			System.out.println((last+1)+" "+n+" "+diff);
		}
	}
}