import java.io.*;
import java.util.*;

class Hexadecimal{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		int a = -1, b = -1, c = -1;
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		while((int)list.get(list.size()-1) < n)
			list.add(list.get(list.size()-1) + list.get(list.size()-2));
		for
	}

}