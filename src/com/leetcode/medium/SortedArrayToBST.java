package com.leetcode.medium;

public class SortedArrayToBST {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public TreeNode sortedArrayToBST(int[] nums) {
	        if(nums.length == 0)
	            return null;
	        return buildBst(nums, 0, nums.length-1);
	    }
	    public TreeNode buildBst(int[] nums, int start, int end) {
	        if(start == end) {
	            TreeNode node = new TreeNode(nums[start]);
	            node.left = null;
	            node.right = null;
	            return node;
	        }
	        else if(start < end) {
	            int mid = (start + end + 1) / 2;
	            TreeNode node = new TreeNode(nums[mid]);
	            node.left = buildBst(nums, start, mid-1);
	            node.right = buildBst(nums, mid+1, end); 
	            return node;
	        }
	        return null;
	    }
	    
	}
}
