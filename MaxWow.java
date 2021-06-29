import java.io.*;
import java.util.*;
class MaxWow{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(sb.length() == 0)
			{
				if(s.charAt(i) == 'o')
					continue;
				else
					sb.append(s.charAt(i));
			}
			if(sb.charAt(sb.length()-1) == 'o')
			{
				count = 0;
				if(s.charAt(i) == 'o')
					continue;
				if(s.charAt(i) == 'w')
					sb.append('w');
				else
				{
					sb.append('v');
					count++;
				}
			}
			if(sb.charAt(sb.length()-1) == 'w')
			{
				count = 0;
				sb.append(s.charAt(i));
				if(s.charAt(i) == 'v')
					count++;
			}
			if(sb.charAt(sb.length()-1) == 'v')
			{
				if(s.charAt(i) == 'v')
				{
					if(count > 0)
					{
						count++;
						sb.append('v');
					}
				}
				else if(s.charAt(i) == 'o')
				{
					if(count >= 2)
					{
						sb.append('o');
						count = 0;
					}
					else
						continue;
				}
				else
				{
					if(count == 1)
					{
						sb.deleteCharAt(sb.length()-1);
						count = 0;
					}
					sb.append('w');
				}
			}
		}
		System.out.print(sb.toString());
	}
}