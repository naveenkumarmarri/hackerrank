package com.leetcode.medium;

public class MaxDepthBinaryTree {
	
	  //Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	    public int maxDepth(TreeNode root) {
	        if(root == null)
	            return 0;
	        else if(root.left == null && root.right!=null)
	            return (maxDepth(root.right)+1 );
	        else if(root.left != null && root.right == null)
	            return maxDepth(root.left)+1;
	        
	        else if(root.left != null && root.right != null)
	            return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
	        return 1;
	    }
	}

