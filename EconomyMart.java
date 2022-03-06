import java.io.*;
import java.util.*;

class EconomyMart{

	public static class Product{
		String name;
		int price;

		public Product(String name, int price){
			this.name = name;
			this.price = price;
		}
	}

	public static StringBuilder sb = new StringBuilder();

	public static void solve(BufferedReader br) throws Exception
	{
		int q = Integer.parseInt(br.readLine());

		PriorityQueue<Product> maxHeap = new PriorityQueue<Product>((a,b) -> checkSmaller(a, b) ? 1 : -1);
		PriorityQueue<Product> minHeap = new PriorityQueue<Product>((a,b) -> checkSmaller(a, b) ? -1 : 1);

		int k = 1;

		while(q-- > 0)
		{
			String[] st = br.readLine().split(" ");

			if(st[0].equals("insert"))
			{
				Product p = new Product(st[1], Integer.parseInt(st[2]));

				Product top = maxHeap.size() > 0 ? maxHeap.peek() : null;

				if(top == null)
					maxHeap.add(p);
				else
				{
					if(maxHeap.size() == k)
					{
						if(checkSmaller(top, p))
							minHeap.add(p);
						else
						{
							maxHeap.add(p);
							minHeap.add(maxHeap.poll());
						}
					}
					else
					{
						if(checkSmaller(p, top))
							maxHeap.add(p);
						else
						{
							minHeap.add(p);
							maxHeap.add(minHeap.poll());
						}
					}
				}
			}
			else if(st[0].equals("view"))
			{
				sb.append(maxHeap.peek().name + "\n");
				k++;

				if(minHeap.size() > 0)
					maxHeap.add(minHeap.poll());
			}
		}
	}

	public static boolean checkSmaller(Product a, Product b)
	{
		return a.price == b.price ? a.name.compareTo(b.name) < 0 : a.price < b.price;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
		System.out.print(sb.toString());
	}
}

/*
Test case 1
6
insert milk 4
insert coffee 3
view
insert pizza 5
insert gum 1
views

Output 1
coffee
coffee


Test case 2
10
insert fries 4
insert soda 2
view
view
insert hamburger 5
view
insert nuggets 4
insert cookie 1
view
view

Output 2
soda
fries
hamburger
nuggets
hamburger

Time Complexity -> O(n * log (n))
Space Complexity -> O(n)
*/