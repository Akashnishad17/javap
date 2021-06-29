import java.io.*;
import java.util.*;

class Equation{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count = 0;
		for(int i = 0; i <= 1000; i++)
		{
			for(int j = 0; j <= 1000; j++)
			{
				if(i*i + j == n && i + j*j == m)
					count++;
			}
		}
		System.out.print(count);
	}

}