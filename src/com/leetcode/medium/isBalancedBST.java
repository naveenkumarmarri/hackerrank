package com.leetcode.medium;

public class isBalancedBST {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	    public boolean isBalanced(TreeNode root) {
	        if(root == null)
	            return true;
	        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
	            return false;
	        return true && isBalanced(root.left) && isBalanced(root.right);
	    }
	    public int getHeight(TreeNode root) {
	        if(root  == null)
	            return 1;
	        return 1+Math.max(getHeight(root.left), getHeight(root.right));
	    }
	}
