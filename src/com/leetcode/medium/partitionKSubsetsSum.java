package com.leetcode.medium;

import java.util.Arrays;

public class partitionKSubsetsSum {
	
	    public boolean canPartitionKSubsets(int[] nums, int k) {
	        int totalSum = Arrays.stream(nums).sum();
	        if(totalSum % k != 0 || k == 0)
	            return false;
	        return getPartitions(0, 0, k, new boolean[nums.length], nums, totalSum/k);
	    }
	    public boolean getPartitions(int pos, int curr, int numBins, boolean[] visited, int[] nums, int target) {
	        if(numBins == 1)
	            return true;
	        if(curr == target)
	            return getPartitions(0, 0, numBins-1, visited, nums, target);
	        for(int i=pos;i<nums.length;i++) {
	            if(!visited[i]) {
	                visited[i] = true;
	                if(getPartitions(i+1, curr+nums[i], numBins, visited, nums, target))
	                    return true;
	                else
	                    visited[i] = false;
	            }
	        }
	        return false;
	    }
	
}
