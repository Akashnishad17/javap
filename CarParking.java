import java.io.*;
import java.util.*;

class CarParking{
	public static void solve(BufferedReader br) throws Exception
	{
		HashMap<String,Integer> map = new HashMap<>();
		map.put("MH04CC2", 1);
		map.put("MH04C2820", 2);
		map.put("MH04BB3232", 3);
		map.put("MH04CC2113", 4);
		map.put("MH04CC2878", 5);
		map.put("MH04BB8", 6);
		map.put("MH04CCC2888", 7);
		map.put("MH04CC1313", 8);
		map.put("MH04CC2222", 9);
		map.put("MH04C1201", 10);
		map.put("MH04CC555", 11);
		map.put("MH04C6565", 12);
		map.put("MH04A7", 13);

		int op = Integer.parseInt(br.readLine());
		String s = br.readLine();
		if((op == 1 || op == 2) && s.length() >= 6 && s.length() <= 12)
		{
			if(op == 1)
			{
				map.put(s, 14);
				System.out.print("CAR PARKED AT POSITION:14");
			}
			else
			{
				if(map.containsKey(s))
					System.out.print("CAR POSITION:"+map.get(s));
				else
					System.out.print("CAR DOES NOT EXISTS");
			}
		}
		else
			System.out.print("INVALID INPUT");
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}