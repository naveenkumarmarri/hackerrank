package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
	
	    public List<String> letterCombinations(String digits) {
	        List<String> list = new ArrayList<String>();
	        if(digits.length() == 0 || digits == null)
	            return list;
	        HashMap<Integer, char[]> map = new HashMap<Integer, char[]>();
	        map.put(1, new char[]{});
	        map.put(2, new char[]{'a','b','c'});
	        map.put(3, new char[]{'d','e','f'});
	        map.put(4, new char[]{'g','h','i'});
	        map.put(5, new char[]{'j','k','l'});
	        map.put(6, new char[]{'m','n','o'});
	        map.put(7, new char[]{'p','q','r','s'});
	        map.put(8, new char[]{'t','u','v'});
	        map.put(9, new char[]{'w','x','y','z'});
	        getCombinations(map,0,new StringBuilder(), digits, list);
	        return list;
	    }
	    public void getCombinations(HashMap<Integer, char[]> map,int start, StringBuilder temp, String digits, List<String> list) {
	        if(temp.length() == digits.length()) {
	            list.add(temp.toString());
	                return;
	        }
	        for(int i=start;i<digits.length();i++) {
	            char[] chars = map.get(Character.getNumericValue(digits.charAt(i)));
	            for(char c: chars) {
	                temp.append(c);
	                getCombinations(map, i+1, temp, digits, list);
	                temp.setLength(temp.length()-1);
	            }
	        }
	            
	    }
	
}
