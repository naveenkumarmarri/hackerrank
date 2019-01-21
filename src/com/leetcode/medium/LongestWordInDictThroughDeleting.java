package com.leetcode.medium;

import java.util.List;

public class LongestWordInDictThroughDeleting {
	
	    public String findLongestWord(String s, List<String> d) {
	        int max = Integer.MIN_VALUE;
	        String largest = null;
	        for(String target: d) {
	            if(checkExists(s, target) && target.length() >= max)  {
	                if(target.length() == max) {
	                    largest = target.compareTo(largest) < 0 ? target : largest;
	                } else {
	                    largest = target;
	                    max = target.length();    
	                }
	                
	            }
	                
	        }
	        return largest == null ? "" : largest;
	    }
	    public boolean checkExists(String s, String d) {
	        int l = 0;
	        int r = 0;
	        while(l < s.length() && r < d.length()) {
	            if(s.charAt(l) == d.charAt(r)) {
	                l++;
	                r++;
	            }
	            else
	                l++;
	        }
	        // System.out.println(r+" "+d+" "+(r == d.length()));
	        return r == d.length();
	    }
	
}
