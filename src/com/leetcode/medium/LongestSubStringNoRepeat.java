package com.leetcode.medium;

import java.util.HashSet;

public class LongestSubStringNoRepeat {
	
	    public int lengthOfLongestSubstring(String s) {
	        if(s.length() == 0)
	            return 0;
	        HashSet<Character> set = new HashSet<Character>();
	        int start = 0;
	        int end = 0;
	        int max = Integer.MIN_VALUE;
	        while(start < s.length()) {
	            if(end < s.length() && !set.contains(s.charAt(end))) {
	                set.add(s.charAt(end));
	                end++;
	                max = Math.max(end-start, max);
	            } else {
	                set.remove(s.charAt(start));
	              start++;  
	            }
	        }
	        return max;
	    }
	
}
