import java.io.*;
import java.util.*;

class NumberPuzzle{

	public static int[][] win = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
	public static boolean check(int[][] A)
	{
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(A[i][j] != win[i][j])
					return false;
			}
		}

		return true;
	}

	public static class State{
		int[][] A;
		int x;
		int y;

		public State(int[][] A, int x, int y)
		{
			this.x = x;
			this.y = y;
			this.A = A;
		}
	}

	public static String convert(int[][] A)
	{
		String res = "";

		for(int[] a : A)
		{
			for(int x : a)
				res += x + "/";
		}

		return res;
	}

	public static boolean valid(int x, int y)
	{
		return x >= 0 && y >= 0 && x < 4 && y < 4;
	}

	public static void swap(int[][] A, int x, int y, int xi, int yi)
	{
		int temp = A[x][y];
		A[x][y] = A[xi][yi];
		A[xi][yi] = temp;
	}

	public static String solve(int[][] A)
	{
		Queue<State> queue = new LinkedList<>();
		HashSet<String> done = new HashSet<>();

		int x = -1, y = -1;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(A[i][j] == 0)
				{
					x = i;
					y = j;
				}
			}
		}

		State state = new State(A, x, y);
		String s = convert(A);

		queue.add(state);
		done.add(s);

		int[] xOff = new int[]{1, -1, 0, 0};
		int[] yOff = new int[]{0, 0, 1, -1};

		while(!queue.isEmpty())
		{
			state = queue.remove();

			if(check(state.A))
				return "YES";

			for(int t = 0; t < 4; t++)
			{
				x = state.x + xOff[t];
				y = state.y + yOff[t];

				if(valid(x, y))
				{
					int[][] new_A = new int[4][4];

					for(int i = 0; i < 4; i++)
					{
						for(int j = 0; j < 4; j++)
							new_A[i][j] = A[i][j];
					}

					swap(new_A, x, y, state.x, state.y);

					s = convert(new_A);
					
					if(!done.contains(s))
					{
						queue.add(new State(new_A, x, y));
						done.add(s);
					}
				}
			}
		}

		return "NO";
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			int[][] A = new int[4][4];

			for(int i = 0; i < 4; i++)
			{
				String[] st = br.readLine().split(" ");
				
				for(int j = 0; j < 4; j++)
					A[i][j] = Integer.parseInt(st[j]);
			}

			System.out.println(solve(A));
		}
	}
}