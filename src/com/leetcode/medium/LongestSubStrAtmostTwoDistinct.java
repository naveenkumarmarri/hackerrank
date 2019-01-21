package com.leetcode.medium;

import java.util.HashSet;

public class LongestSubStrAtmostTwoDistinct {
	    public int lengthOfLongestSubstringTwoDistinct(String s) {
	        if(s.length() == 0 || s.length() == 1)
	            return s.length();
	        HashSet<Character> set = new HashSet<Character>();
	        int start = 0;
	        int end = 0;
	        int max = Integer.MIN_VALUE;
	        int count = 0;
	        while(start < s.length()) {
	            if(end < s.length() && set.size()<=2) {
	                set.add(s.charAt(end));
	                if(set.size() <= 2) {
	                    count++;
	                    max = Math.max(max, count);
	                    end++;    
	                }
	            } else {
	                set.remove(s.charAt(start));
	                start++;
	                end = start;
	                count=0;
	            }
	        }
	        return max;
	    }
	
}
