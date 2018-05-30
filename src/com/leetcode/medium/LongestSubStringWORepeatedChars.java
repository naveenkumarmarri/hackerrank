package com.leetcode.medium;

import java.util.ArrayList;

public class LongestSubStringWORepeatedChars {
	
	    public int lengthOfLongestSubstring(String s) {
	        char [] inp = s.toCharArray();
	        int max = 0;        
	        for(int i=0;i<inp.length;i++) {
	            ArrayList<Character> set = new ArrayList<Character>();
	            for(int j=i;j<inp.length;j++) {
	                if(set.contains(inp[j]))
	                    break;
	                else {
	                    set.add(inp[j]);
	                    if(set.size() > max)
	                        max = set.size();
	                }
	            }
	        }
	        return max;
	    }
	
}
