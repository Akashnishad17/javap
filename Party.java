	import java.io.*;
	import java.util.*;

	class Party{
		public static void solve(Scanner sc)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			HashMap<Integer,List<Integer>> map = new HashMap<>();
			List<Integer> childs;
			
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			
			for(int i = 0; i < n; i++)
			{
				if(arr[i] != -1)
					arr[i]--;
				childs = map.getOrDefault(arr[i], new ArrayList<>());
				childs.add(i);
				map.put(arr[i], childs);
			}

			Queue<Integer> queue = new LinkedList<>();
			queue.add(-1);
			int gp = -1;

			while(!queue.isEmpty())
			{
				int size = queue.size();
				gp++;

				while(size-- > 0)
				{
					int node = queue.remove();
					childs = map.getOrDefault(node, new ArrayList<>());

					for(int x : childs)
						queue.add(x);
				}
			}

			System.out.println(gp);
		}

		public static void main(String[] args) throws Exception
		{
			Scanner sc = new Scanner(new File("input4.txt"));
			System.setOut(new PrintStream(new File("output.txt")));
			solve(sc);
		}
	}