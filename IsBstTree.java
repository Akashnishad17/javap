import java.io.*;
import java.util.*;

class IsBstTree{

	public static class BSTNode{
		
		public int value;
		public BSTNode left;
		public BSTNode right;

		public BSTNode(int value, BSTNode left, BSTNode right)
		{
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public static int solve(BufferedReader br) throws Exception
	{
		int n = Integer.parseInt(br.readLine());

		HashMap<Integer, BSTNode> map = new HashMap<>();

		int value, left, right;

		for(int i = 0; i < n; i++)
		{
			String[] st = br.readLine().split(" ");

			value = Integer.parseInt(st[0]);
			left = Integer.parseInt(st[1]);
			right = Integer.parseInt(st[2]);

			BSTNode leftNode = left == -1 ? null : map.getOrDefault(left, new BSTNode(left, null, null));
			BSTNode rightNode = right == -1 ? null : map.getOrDefault(right, new BSTNode(right, null, null));
			BSTNode node = map.getOrDefault(value, new BSTNode(value, leftNode, rightNode));
			node.left = leftNode;
			node.right = rightNode;

			map.put(value, node);
			
			if(left != -1)
				map.put(left, leftNode);
			if(right != -1)
				map.put(right, rightNode);
		}

		HashSet<Integer> data = new HashSet<Integer>();
		HashSet<Integer> parent = new HashSet<Integer>(map.keySet());

		for(Map.Entry<Integer, BSTNode> e : map.entrySet())
		{
			value = e.getKey();
			BSTNode node = e.getValue();

			if(node.left != null)
			{
				data.add(node.left.value);
				if(parent.contains(node.left.value))
					parent.remove(node.left.value);
			}

			if(node.right != null)
			{
				data.add(node.right.value);
				if(parent.contains(node.right.value))
					parent.remove(node.right.value);
			}

			data.add(value);
		}

		if(map.size() != data.size())
			return -1;

		if(parent.size() != 1)
			return -1;

		int root = -1;

		for(int x : parent)
			root = x;

		BSTNode node = map.get(root);

		if(!isBST(node, -1, 1000000000))
			return -1;

		return root;
	}

	public static boolean isBST(BSTNode root, int left, int right)
	{
		if(root == null)
			return true;

		if(left < root.value && root.value < right)
			return isBST(root.left, left, root.value) && isBST(root.right, root.value, right);

		return false;
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		int t = 1;
		StringBuilder sb = new StringBuilder();

		while(t-- > 0)
			sb.append(solve(br)+"\n");

		System.out.print(sb.toString());
	}
}