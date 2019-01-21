package com.leetcode.medium;

import java.util.HashMap;

class Trie {

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    TrieNode root = new TrieNode();
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.length() == 0)
            return;
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++) {
            if(curr.children.containsKey(word.charAt(i)))
                curr = curr.children.get(word.charAt(i));
            else {
                curr.children.put(word.charAt(i), new TrieNode());
                curr = curr.children.get(word.charAt(i));
            }
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length() == 0)
            return false;
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++) {
            curr = curr.children.get(word.charAt(i));
            if(curr == null)
                return false;
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0)
            return false;
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            curr = curr.children.get(prefix.charAt(i));
            if(curr == null)
                return false;
        }
        return true;
    }
}
class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isEnd = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */