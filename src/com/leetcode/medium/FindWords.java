package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindWords {
	    public List<String> findWords(char[][] board, String[] words) {
	        TrieNode_ root = new TrieNode_();
	        buildTrie(root, words);
	        List<String> result = new ArrayList<String>();
	        for(int i=0;i<board.length;i++) {
	            for(int j=0;j<board[0].length;j++) {
	                TrieNode_ curr = root;
	                dfs(board, i, j, curr, result);
	            }
	        }
	        return result;
	    }
	    public void dfs(char[][] board, int i, int j, TrieNode_ curr, List<String> result) {
	        if(i<0 || j < 0 || i>board.length-1 || j> board[0].length-1)
	            return;
	        char val = board[i][j];
	        if(curr.children.containsKey(val)) {
	            curr = curr.children.get(val);
	            if(curr.word != null) {
	                result.add(curr.word);
	                curr.word = null;
	            }
	            board[i][j] = '#';
	            dfs(board, i-1, j, curr, result);
	            dfs(board, i+1, j, curr, result);
	            dfs(board, i, j-1, curr, result);
	            dfs(board, i, j+1, curr, result);
	            board[i][j] = val;
	        }
	        return ;
	        
	    }
	    public void buildTrie(TrieNode_ root, String[] words) {
	        for(String word: words)
	            trieWord(root, word);
	    } 
	    public void trieWord(TrieNode_ root, String word) {
	        if(word.length() == 0)
	            return;
	        TrieNode_ curr = root;
	        for(int i=0;i<word.length();i++) {
	            if(!curr.children.containsKey(word.charAt(i)))
	                curr.children.put(word.charAt(i), new TrieNode_());
	            curr = curr.children.get(word.charAt(i));
	        }
	        curr.word = word;
	    }
	}
	

class TrieNode_ {
    HashMap<Character, TrieNode_> children = new HashMap<Character, TrieNode_>();
    String word = null;
}