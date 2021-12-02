import java.io.*;
import java.util.*;

class ProblemDifficulties{
	public static int solve(BufferedReader br) throws Exception
	{
		String[] st = br.readLine().split(" ");

		int[] arr = new int[4];

		HashSet<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < 4; i++){
			arr[i] = Integer.parseInt(st[i]);
			set.add(arr[i]);
		}

		if(set.size() >= 3)
			return 2;

		if(set.size() == 2)
		{
			Arrays.sort(arr);

			if(arr[0] == arr[1] && arr[2] == arr[3])
				return 2;
			else
				return 1;
		}

		return 0;
		
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}