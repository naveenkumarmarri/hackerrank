package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSums {

	
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        if(root == null)
	            return new ArrayList<List<Integer>>();
	        return findSum(root, 0,sum,"", new ArrayList<List<Integer>>());
	    }
	    public ArrayList<List<Integer>> findSum(TreeNode root, int curSum, int targetSum,String path, ArrayList<List<Integer>> allpaths) {
	        
	        if(root.left == null && root.right == null && curSum+root.val == targetSum) {
	            path = path+root.val;
	            String[] tokens = path.split(",");
	            ArrayList<Integer> list_path = new ArrayList<Integer>();
	            for(String token : tokens)
	                list_path.add(Integer.parseInt(token));
	            allpaths.add(list_path);
	        }
	            
	        
	        if(root.left != null) {
	            
	            findSum(root.left, curSum+root.val, targetSum, path+root.val+",", allpaths);
	            //path.remove(i);
	        }
	            
	        
	        if(root.right != null) {
	            
	            findSum(root.right, curSum+root.val, targetSum, path+root.val+",", allpaths);
	            //path.remove(i);
	        }
	        return allpaths;
	    }
	}
