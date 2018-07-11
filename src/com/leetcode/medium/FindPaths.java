package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindPaths {
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
	    public List<String> binaryTreePaths(TreeNode root) {
	        if(root == null)
	            return new ArrayList<String>();
	        return findPaths(root,"", new ArrayList<String>());
	    }
	    public ArrayList<String> findPaths(TreeNode root,String path, ArrayList<String> list) {
	        if(root.left == null && root.right == null)
	            list.add(path+root.val);
	        if(root.left != null)
	             findPaths(root.left, path+root.val+"->", list);    
	        if(root.right != null)
	             findPaths(root.right, path+root.val+"->", list);
	    
	        return list;
	            
	    }
	}
}
