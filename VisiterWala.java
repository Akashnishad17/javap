import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

// @editable code
class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
      	result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    public int getResult() {
        return (int)result;
    }

    public void visitNode(TreeNode node) {
      	if(node.getColor().equals(Color.RED))
            result = (result * node.getValue())%1000000007;
    }

    public void visitLeaf(TreeLeaf leaf) {
      	if(leaf.getColor().equals(Color.RED))
            result = (result * leaf.getValue())%1000000007;
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeafSum = 0;
    private int greenLeafSum = 0;
    public int getResult() {
        return Math.abs(evenDepthNonLeafSum-greenLeafSum);
    }

    public void visitNode(TreeNode node) {
    	if(node.getDepth()%2 == 0)
            evenDepthNonLeafSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor().equals(Color.GREEN))
            greenLeafSum += leaf.getValue();
    }
}

public class VisiterWala {
  
    public static Tree solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] col = new int[n];
        int[][] path = new int[n-1][2];
        for(int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            col[i] = sc.nextInt();
        HashMap<Integer,TreeSet<Integer>> set = new HashMap<>();
        for(int i = 0; i < n-1; i++)
        {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            if(!set.containsKey(parent))
            {
                TreeSet<Integer> childs = new TreeSet<>();
                childs.add(child);
                set.put(parent, childs);
            }
            else
            {
                TreeSet<Integer> childs = set.get(parent);
                childs.add(child);
            }
            if(!set.containsKey(child))
            {
                TreeSet<Integer> childs = new TreeSet<>();
                childs.add(parent);
                set.put(child, childs);
            }
            else
            {
                TreeSet<Integer> childs = set.get(child);
                childs.add(parent);
            }
        }
        sc.close();
        Tree root = new TreeNode(val[0],Color.values()[col[0]],0);
        Queue<Tree> queue = new LinkedList<>();
        Queue<Integer> number = new LinkedList<>(); 
        int depth = 1;
        queue.add(root);
        number.add(1);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- > 0)
            {
                TreeNode node = (TreeNode)queue.remove();
                int num = number.remove();
                TreeSet<Integer> childs = set.get(num);
                Iterator<Integer> it = childs.iterator();
                while(it.hasNext())
                {
                    int child = it.next();
                    set.get(child).remove(num);
                    if(set.get(child).size() == 0)
                        set.remove(child);
                    if(set.containsKey(child))
                    {
                        Tree newChild = new TreeNode(val[child-1],Color.values()[col[child-1]], depth);
                        queue.add(newChild);
                        number.add(child);
                        node.addChild(newChild);
                    }
                    else
                    {   
                        Tree newChild = new TreeLeaf(val[child-1],Color.values()[col[child-1]], depth);
                        node.addChild(newChild);
                    }
                }
            }
            depth++;
        }
        return root;
    }
// @editable code

    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}