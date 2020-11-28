import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinRoad {
    public static class edge{
        int parent;
        int child;
        int weight;
        public edge(int parent, int child, int weight)
        {
            this.parent = parent;
            this.child = child;
            this.weight = weight;
        }
    }
    public static class minPath implements Comparator<edge>{
        @Override
        public int compare(edge e1, edge e2)
        {
            if(e1.weight > e2.weight)
                return 1;
            else
                return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cities = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            cities[i][0] = sc.nextInt();
            cities[i][1] = sc.nextInt();
        }
        PriorityQueue<edge> pq = new PriorityQueue<edge>(new minPath());
        for(int i = 0; i < n-1; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                int wt = Math.min((int)Math.abs(cities[i][0]-cities[j][0]),(int)Math.abs(cities[i][1]-cities[j][1]));
                edge e = new edge(i,j,wt);
                pq.add(e);
            }
        }
        int min = 0;
        HashSet<Integer> nodes = new HashSet<>();
        for(int i = 1; i < n; i++)
        {
            edge e = pq.poll();
            if(nodes.contains(e.parent) && nodes.contains(e.child))
                continue;
            else if(nodes.contains(e.parent))
                nodes.add(e.child);
            else if(nodes.contains(e.child))
                nodes.add(e.parent);
            else
            {
                nodes.add(e.parent);
                nodes.add(e.child);
            }
            min += e.weight;
        }
        System.out.println(min);
        sc.close();
    }
}