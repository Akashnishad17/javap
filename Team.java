import java.io.*;
import java.util.*;

class Team{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int counts = 0, count;
		while(n-- > 0)
		{
			count = 0;
			count += sc.nextInt();
			count += sc.nextInt();
			count += sc.nextInt();
			if(count >= 2)
				counts++;
		}
		System.out.print(counts);
	}

}