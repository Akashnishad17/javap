import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiffColor {

    public static class TrieNode{
        TrieNode[] child;
    }
    public static TrieNode getNode()
    {
        TrieNode trie = new TrieNode();
        trie.child = new TrieNode[2];
        return trie;
    }
    public static TrieNode root = getNode();
    public static void insert(String s)
    {
        TrieNode trie = root;
        int index;
        for(int i = 0; i < s.length(); i++)
        {
            index = Character.getNumericValue(s.charAt(i));
            if(trie.child[index] == null)
                trie.child[index] = getNode();
            trie = trie.child[index];
        }
    }

    public static int search(String s)
    {
        return dfs(s, 0, root);
    }

    public static int dfs(String s, int level, TrieNode trie)
    {
        if(level == s.length())
            return 1;
        int index = Character.getNumericValue(s.charAt(level));
        if(index == 1)
        {
            if(trie.child[0] == null)
                return -1;
            else
                return dfs(s, level+1, trie.child[0]);
        }
        int left = trie.child[0] == null ? -1 : dfs(s, level+1, trie.child[0]);
        int right = trie.child[1] == null ? -1 : dfs(s, level+1, trie.child[1]);
        return (left == 1 || right == 1) ? 1 : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] groups = new String[n];
        
        for(int i = 0; i < n; i++)
            groups[i] = sc.next();
        sc.close();

        for(int i = 0; i < n; i++)
            insert(groups[i]);

        for(int i = 0; i < n; i++)
            System.out.println(search(groups[i]));
    }
}