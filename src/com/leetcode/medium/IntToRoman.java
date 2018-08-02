package com.leetcode.medium;

import java.util.HashMap;

public class IntToRoman {

	    public String intToRoman(int num) {
	        HashMap<Integer, String> map = new HashMap<Integer, String>();
	        map.put(1, "I");
	        map.put(2, "II");
	        map.put(3, "III");
	        map.put(6, "VI");
	        map.put(7, "VII");
	        map.put(8, "VIII");
	        map.put(4, "IV");
	        map.put(9, "IX");
	        map.put(5, "V");
	        map.put(10, "X");
	        
	        map.put(20, "XX");
	        map.put(30, "XXX");
	        map.put(40, "XL");
	        map.put(50, "L");
	        map.put(60, "LX");
	        map.put(70, "LXX");
	        map.put(80, "LXXX");
	        map.put(90, "XC");
	        
	        map.put(100, "C");
	        
	        map.put(200, "CC");
	        map.put(300, "CCC");
	        map.put(400, "CD");
	        map.put(500, "D");
	        map.put(600, "DC");
	        map.put(700, "DCC");
	        map.put(800, "DCCC");
	        map.put(900, "CM");
	        map.put(1000, "M");
	        map.put(2000, "MM");
	        map.put(3000, "MMM");
	        
	        
	       return getFactors(num, map);
	        
	        
	    }
	    public String getFactors(int num, HashMap<Integer, String> map) {
	        String temp = num+"";
	        char[] nums = temp.toCharArray();
	       
	        int prod = 1;
	        String ret = "";
	        for(int i=nums.length-1; i>=0;i--) {
	           int val = prod*Character.getNumericValue(nums[i]);
	            if(map.containsKey(val))
	                ret = map.get(val)+ret;
	            prod *= 10;
	        }
	        
	        return  ret;
	    }
	}
