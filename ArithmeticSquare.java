import java.io.*;
import java.util.*;

class ArithmeticSquare{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int[][] res = new int[3][3];

		for(int i = 0; i < 3; i++)
			res[0][i] = Integer.parseInt(st[i]);

		st = br.readLine().split(" ");

		res[1][0] = Integer.parseInt(st[0]);
		res[1][2] = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");

		for(int i = 0; i < 3; i++)
			res[2][i] = Integer.parseInt(st[i]);

		int count = 0;

		if(res[0][0] + res[0][2] == 2 * res[0][1])
			count++;

		if(res[2][0] + res[2][2] == 2 * res[2][1])
			count++;

		if(res[0][0] + res[2][0] == 2 * res[1][0])
			count++;

		if(res[0][2] + res[2][2] == 2 * res[1][2])
			count++;

		HashMap<Integer, Integer> map = new HashMap<>();

		int sum = res[0][0] + res[2][2];
		if(sum % 2 == 0)
			map.put(sum, map.getOrDefault(sum, 0) + 1);

		sum = res[0][1] + res[2][1];
		if(sum % 2 == 0)
			map.put(sum, map.getOrDefault(sum, 0) + 1);

		sum = res[1][0] + res[1][2];
		if(sum % 2 == 0)
			map.put(sum, map.getOrDefault(sum, 0) + 1);


		sum = res[2][0] + res[0][2];
		if(sum % 2 == 0)
			map.put(sum, map.getOrDefault(sum, 0) + 1);

		if(map.size() > 0)
			count += Collections.max(map.values());

		return count;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= t; i++)
			sb.append("Case #"+i+": "+solve(br)+"\n");

		System.out.print(sb.toString());
	}
}