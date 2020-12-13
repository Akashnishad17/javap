import java.io.*;
import java.util.*;

class WordSearch{
    
    class Trie{
        String word;
        Trie[] child;
    }
    
    public Trie getNode()
    {
        Trie node = new Trie();
        node.word = null;
        node.child = new Trie[26];
        return node;
    }
    
    public void insertWord(String s)
    {
        Trie node = root;
        int index;
        
        for(int i = 0; i < s.length(); i++)
        {
            index = s.charAt(i) - 'a';
            
            if(node.child[index] == null)
                node.child[index] = getNode();
            
            node = node.child[index];
        }
        node.word = s;
    }
    
    Trie root;
    List<String> out;
    
    public List<String> findWords(char[][] board, String[] words) {
        
        out = new ArrayList<>();
        
        if(board.length == 0 || board[0].length == 0 || words.length == 0)
            return out;
        
        root = getNode();
        
        for(String word : words)
            insertWord(word);
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
                backTrack(board, i, j, root);
        }
        
        Collections.sort(out);
        return out;
    }
    
    public void backTrack(char[][] board, int row, int col, Trie root)
    {
        if(row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] == '.')
            return;
        
        char cur = board[row][col];
        Trie next = root.child[cur-'a'];
        
        if(next == null)
            return;
        
        if(next.word != null)
        {
            out.add(next.word);
            next.word = null;
        }
        
        board[row][col] = '.';
        
        backTrack(board, row-1, col, next);
        backTrack(board, row+1, col, next);
        backTrack(board, row, col-1, next);
        backTrack(board, row, col+1, next);
        
        board[row][col] = cur;
    }

    public static void main(String[] args)
    {
        char[][] board = new char[][]{
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}};

        String[] words = new String[]{"oath","pea","eat","rain"};

        List<String> res = new WordSearch().findWords(board, words);

        System.out.println(res);
    }
}