package com.leetcode.medium;

public class InvertBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	    public TreeNode invertTree(TreeNode root) {
	        if(root == null)
	            return null;
	        TreeNode temp = root.left;
	        root.left = root.right;
	        root.right = temp;
	        invertTree(root.left);
	        invertTree(root.right);
	        return root;
	    }
	
}
