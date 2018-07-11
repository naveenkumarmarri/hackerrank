package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class ProductOfArrayExceptItself {
	
	    public int[] productExceptSelf(int[] nums) {
	        if(nums.length == 0)
	            return nums;
	        int [] temp = new int[nums.length];
	        temp[0] = 1;
	        
	        for(int i=1;i<nums.length;i++) {
	            temp[i] = nums[i-1]*temp[i-1];
	            
	        }
	        int prod = 1;
	        for(int i=nums.length-2; i>=0; i--) {
	            prod *= nums[i+1];
	            temp[i] *= prod;
	            
	        }
	        return temp;
	        
	    }
	 
	
}
