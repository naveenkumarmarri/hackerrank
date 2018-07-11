package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        int height = getHeight(root);
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        for(int i=0; i< height; i++) {
	            ArrayList<Integer> al = new ArrayList<Integer>();
	            list.add(getNodes(root, i, 0, al));
	        }
	        return list;
	    }
	    public ArrayList<Integer> getNodes(TreeNode root, int height, int i, ArrayList<Integer> al) {
	        if(root == null)
	            return al;
	        if(i==height)
	            al.add(root.val);
	        if(root.left != null && root.right != null && i!=height) {
	            getNodes(root.right, height, i+1, getNodes(root.left, height, i+1, al));
	        }
	        else if(root.left == null && root.right != null && i!=height) 
	            return getNodes(root.right, height, i+1, al);
	        else
	            return getNodes(root.left, height, i+1, al);
	        return al;
	    }
	    public int getHeight(TreeNode root) {
	        if(root == null)
	            return 0;
	        else if(root.left != null && root.right != null)
	            return 1+Math.max(getHeight(root.left), getHeight(root.right));
	        else if(root.left != null && root.right == null)
	            return 1+getHeight(root.left);
	        else
	            return 1+getHeight(root.right);
	    }
	}
}
