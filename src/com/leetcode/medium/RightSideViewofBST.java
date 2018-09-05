package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewofBST {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> list = new ArrayList<Integer>();
	        if(root == null)
	            return list;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
	        queue.offer(root);
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            
	            List<Integer> temp = new ArrayList<Integer>();
	            for(int i = 0; i < size ; i++) {
	                TreeNode polledNode = queue.poll();
	                if(polledNode.left != null) queue.offer(polledNode.left);
	                if(polledNode.right != null) queue.offer(polledNode.right);
	                temp.add(polledNode.val);                    
	            }
	            levelOrder.add(temp);
	        }
	        for(List<Integer> al: levelOrder) {
	            list.add(al.get(al.size() - 1));
	        }
	        return list;
	    }
	}

