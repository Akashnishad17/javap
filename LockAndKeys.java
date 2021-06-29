import java.io.*;
import java.util.*;

class LockAndKeys{
	public static void solve(BufferedReader br) throws Exception
	{
		HashMap<String, Integer> map = new HashMap<>();
		int blank = 0;
		int total = 0;
		String s;

		while(true)
		{
			s = br.readLine();
			if(s.equals("q"))
				break;

			if(s.equals(" "))
				blank++;
			else
				map.put(s, map.getOrDefault(s, 0) + 1);

			total++;
		}

		System.out.println("BLANK KEYS:"+blank);
		System.out.println("TOTAL KEYS:"+total);
		System.out.print("NUMBER OF LOCKS:"+map.size());
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}